package online.swiftlift.swiftlift.model.dto

import online.swiftlift.swiftlift.model.enum.GenderType

data class UserDTO(
    val username: String,
    val password: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val weight: Double,
    val gender: GenderType,
    )
