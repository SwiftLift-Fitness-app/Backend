package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.exercise.WorkoutAddBindingModel
import online.swiftlift.swiftlift.model.dto.exercise.WorkoutDTO

interface WorkoutService {

    fun getAll(): List<WorkoutDTO>

    fun getByName(name: String): WorkoutDTO

    fun addWorkout(workoutAddBindingModel: WorkoutAddBindingModel): WorkoutDTO

    fun changeWorkout(workoutAddBindingModel: WorkoutAddBindingModel): WorkoutDTO

    fun deleteWorkout(name: String)
}