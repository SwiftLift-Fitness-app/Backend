package online.swiftlift.swiftlift.model.dto.exercise

data class WorkoutAddBindingModel(
        val name: String,
        val exercises: Map<String, String>,
        val primaryArea: String,
)
