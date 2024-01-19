package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.user.*

interface UserService {

    fun register(userRegisterBindingModel: UserRegisterBindingModel): UserDTO

    fun submitSurvey(userSurveyBindingModel: UserSurveyBindingModel): UserDTO

    fun login(userLoginBindingModel: UserLoginBindingModel): UserDTO

    fun getAll(): List<UserDTO>
    fun profileData(username: String): UserProfileDTO
}