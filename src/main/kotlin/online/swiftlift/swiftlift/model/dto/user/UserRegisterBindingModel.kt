package online.swiftlift.swiftlift.model.dto.user

data class UserRegisterBindingModel(
    val username: String,
    val password: String,
    val confirmPassword: String,
    val email: String,
    )