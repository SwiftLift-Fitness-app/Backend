package online.swiftlift.swiftlift.model.dto.user

data class UserSurveyBindingModel(
    val username: String,
    val age: Int,
    val weight: Double,
    val height: Int,
    val gender: Char,
    val level: String,
)
