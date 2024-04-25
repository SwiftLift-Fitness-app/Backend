package online.swiftlift.swiftlift.model.dto.exercise

data class RoutineAddBindingModel(
    val name: String = "",
    val description: String = "",
    //Map<workoutId, day>
    val workouts: Map<String, String> = mutableMapOf(),
    val username: String = "",
)
