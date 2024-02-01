package online.swiftlift.swiftlift.model.dto.exercise
data class ExerciseDTO(
    val name: String,
    val description: String,
    val area: PrimaryAreaDTO,
    val equipment: String,
)