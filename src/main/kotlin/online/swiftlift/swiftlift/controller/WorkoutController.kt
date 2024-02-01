package online.swiftlift.swiftlift.controller

import online.swiftlift.swiftlift.model.dto.exercise.WorkoutAddBindingModel
import online.swiftlift.swiftlift.service.WorkoutService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/workouts")
class WorkoutController(private val workoutService: WorkoutService) {

    @GetMapping("/all")
    fun getAllWorkouts() = workoutService.getAll()

    @GetMapping("/add")
    fun addWorkout(workoutAddBindingModel: WorkoutAddBindingModel) = workoutService.addWorkout(workoutAddBindingModel)

    @GetMapping("/{name}")
    fun getWorkoutByName(@PathVariable name: String) = workoutService.getByName(name)

    @PatchMapping("/{name}")
    fun changeWorkout(workoutAddBindingModel: WorkoutAddBindingModel) = workoutService.changeWorkout(workoutAddBindingModel)

    @DeleteMapping("/{name}")
    fun deleteWorkoutByName(@PathVariable name: String) = workoutService.deleteWorkout(name)
}