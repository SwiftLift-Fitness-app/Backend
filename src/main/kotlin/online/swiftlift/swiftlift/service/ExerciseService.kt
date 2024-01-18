package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.exercise.ExerciseAddBindingModel
import online.swiftlift.swiftlift.model.dto.exercise.ExerciseDTO

interface ExerciseService {

    fun addExercise(exercise: ExerciseAddBindingModel): ExerciseDTO

    fun findByName(name: String): ExerciseDTO
}