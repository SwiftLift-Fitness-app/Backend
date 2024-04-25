package online.swiftlift.swiftlift.model.dto.exercise

import online.swiftlift.swiftlift.model.dto.DayDTO

data class RoutineDTO(
    val name: String = "",
    val description: String = "",
    val workouts: Map<WorkoutDTO, DayDTO> = mutableMapOf(),
    val username: String = "",
)
