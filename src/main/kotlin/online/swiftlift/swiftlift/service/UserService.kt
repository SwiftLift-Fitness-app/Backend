package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.user.UserDTO
import online.swiftlift.swiftlift.model.dto.user.UserLoginBindingModel
import online.swiftlift.swiftlift.model.dto.user.UserRegisterBindingModel

interface UserService {

    fun register(userRegisterBindingModel: UserRegisterBindingModel): UserDTO

    fun login(userLoginBindingModel: UserLoginBindingModel): UserDTO
    fun getAll(): List<UserDTO>
}