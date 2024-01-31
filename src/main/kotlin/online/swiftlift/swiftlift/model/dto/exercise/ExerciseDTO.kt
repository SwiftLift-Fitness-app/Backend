package online.swiftlift.swiftlift.model.dto.exercise

import java.time.LocalDateTime

data class ExerciseDTO(
    val name: String,
    val description: String,
    val area: PrimaryAreaDTO,
    val created: LocalDateTime,
)