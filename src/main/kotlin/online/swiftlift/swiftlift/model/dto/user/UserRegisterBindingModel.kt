package online.swiftlift.swiftlift.model.dto.user

data class UserRegisterBindingModel(
    val username: String,
    val password: String,
    val confirmPassword: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val weight: Double,
    val gender: String,
    )