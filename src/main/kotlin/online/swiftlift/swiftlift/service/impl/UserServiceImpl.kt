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

        return userRepository
            .findByUsername(userRegisterBindingModel.username)
            .orElseThrow { UserNotFoundException(userRegisterBindingModel.username) }
            .toDTO()
    }

    override fun submitSurvey(userSurveyBindingModel: UserSurveyBindingModel): UserDTO {

//        val username = loggedUser().name
        val user = userRepository.findByUsername(userSurveyBindingModel.username).orElseThrow { UserNotFoundException(userSurveyBindingModel.username) }

        user.age = userSurveyBindingModel.age
        user.weight = userSurveyBindingModel.weight
        user.height = userSurveyBindingModel.height
        user.gender = when(userSurveyBindingModel.gender) {
            'm' -> GenderType.MALE
            'f' -> GenderType.FEMALE
            else -> GenderType.OTHER
        }

        userRepository.save(user)
        return user.toDTO()
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

    override fun login(userLoginBindingModel: UserLoginBindingModel) =
        userRepository
            .findByUsername(userLoginBindingModel.username)
            .orElseThrow { UserNotFoundException(userLoginBindingModel.username) }
            .toDTO()

    override fun getAll(): List<UserDTO> =
        userRepository.findAll().map { it.toDTO() }

    private fun UserEntity.toDTO() =
        UserDTO(
            username,
            email,
            firstName,
            lastName,
            age,
            weight,
            height,
            gender.toString()
        )

    private fun loggedUser() = authenticationFacade.authentication()
}