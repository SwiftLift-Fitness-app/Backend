package online.swiftlift.swiftlift.model.dto.exercise

data class WorkoutDTO(val name: String,
                      val exercises: Map<ExerciseDTO, String>,
                      val primaryArea: String,
)
