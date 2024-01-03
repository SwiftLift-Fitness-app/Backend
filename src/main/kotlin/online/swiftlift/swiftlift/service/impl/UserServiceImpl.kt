package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.UserNotFoundException
import online.swiftlift.swiftlift.model.dto.user.UserDTO
import online.swiftlift.swiftlift.model.dto.user.UserLoginBindingModel
import online.swiftlift.swiftlift.model.dto.user.UserRegisterBindingModel
import online.swiftlift.swiftlift.model.entity.UserEntity
import online.swiftlift.swiftlift.model.enum.GenderType
import online.swiftlift.swiftlift.repository.UserRepository
import online.swiftlift.swiftlift.service.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {

    override fun register(userRegisterBindingModel: UserRegisterBindingModel): UserDTO {

        userRepository.save(UserEntity(
            userRegisterBindingModel.username,
            userRegisterBindingModel.password,
            userRegisterBindingModel.email,
            userRegisterBindingModel.firstName,
            userRegisterBindingModel.lastName,
            userRegisterBindingModel.age,
            userRegisterBindingModel.weight,
            GenderType.valueOf(userRegisterBindingModel.gender.uppercase())))

        return entityToDTO(userRepository
            .findByUsername(userRegisterBindingModel.username)
            .orElseThrow { UserNotFoundException(userRegisterBindingModel.username) } )
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
            userEntity.gender.toString()
        )
}