package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.RoleNotFoundException
import online.swiftlift.swiftlift.exception.UserNotFoundException
import online.swiftlift.swiftlift.model.dto.user.*
import online.swiftlift.swiftlift.model.entity.user.UserEntity
import online.swiftlift.swiftlift.model.enum.GenderType
import online.swiftlift.swiftlift.model.enum.Role
import online.swiftlift.swiftlift.repository.RoleRepository
import online.swiftlift.swiftlift.repository.UserRepository
import online.swiftlift.swiftlift.service.UserService
import online.swiftlift.swiftlift.util.authentication.AuthenticationFacade
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository,
                      private val roleRepository: RoleRepository,
                      private val encoder: PasswordEncoder,
                      private val authenticationFacade: AuthenticationFacade) : UserService {

    override fun register(userRegisterBindingModel: UserRegisterBindingModel): UserDTO {

        val role = roleRepository.findByName(Role.USER).orElseThrow { RoleNotFoundException(Role.USER) }

        userRepository.save(
            UserEntity(
            username = userRegisterBindingModel.username,
            password = encoder.encode(userRegisterBindingModel.password),
            email = userRegisterBindingModel.email,
            roles = mutableSetOf(role)
        )
        )

        return entityToDTO(userRepository
            .findByUsername(userRegisterBindingModel.username)
            .orElseThrow { UserNotFoundException(userRegisterBindingModel.username) } )
    }

    override fun submitSurvey(userSurveyBindingModel: UserSurveyBindingModel): UserDTO {

        val username = loggedUser().name
        val user = userRepository.findByUsername(username).orElseThrow { UserNotFoundException(username) }

        user.age = userSurveyBindingModel.age
        user.weight = userSurveyBindingModel.weight
        user.height = userSurveyBindingModel.height
        user.gender = when(userSurveyBindingModel.gender) {
            'm' -> GenderType.MALE
            else -> GenderType.FEMALE
        }

        userRepository.save(user)
        return entityToDTO(user)
    }

    override fun profileData(username: String): UserProfileDTO {
        val user = userRepository.findByUsername(username).orElseThrow { UserNotFoundException(username) }
        return UserProfileDTO(
            username = user.username,
            fullName = user.firstName + user.lastName,
            age = user.age,
            weight = user.weight,
            height = user.height,
            gender = user.gender.toString()
        )
    }

    override fun login(userLoginBindingModel: UserLoginBindingModel): UserDTO {
        return entityToDTO(userRepository
            .findByUsername(userLoginBindingModel.username)
            .orElseThrow { UserNotFoundException(userLoginBindingModel.username) } )
    }

    override fun getAll(): List<UserDTO> =
        userRepository.findAll().map { x -> entityToDTO(x) }

    private fun entityToDTO(userEntity: UserEntity) =
        UserDTO(
            userEntity.username,
            userEntity.email,
            userEntity.firstName,
            userEntity.lastName,
            userEntity.age,
            userEntity.weight,
            userEntity.height,
            userEntity.gender.toString()
        )

    private fun loggedUser() = authenticationFacade.authentication()
}