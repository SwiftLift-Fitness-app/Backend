package online.swiftlift.swiftlift.controller

import online.swiftlift.swiftlift.model.dto.exercise.ExerciseAddBindingModel
import online.swiftlift.swiftlift.model.dto.exercise.ExerciseDTO
import online.swiftlift.swiftlift.service.ExerciseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/exercises")
class ExerciseController(private val exerciseService: ExerciseService) {

    @PostMapping("/add")
    fun addExercise(@RequestBody exerciseAddBindingModel: ExerciseAddBindingModel): ResponseEntity<ExerciseDTO> =
        ResponseEntity.ok(exerciseService.addExercise(exerciseAddBindingModel))

    @GetMapping("/all")
    fun allExercises(): ResponseEntity<Set<ExerciseDTO>> =
        ResponseEntity.ok(exerciseService.getAll())
}