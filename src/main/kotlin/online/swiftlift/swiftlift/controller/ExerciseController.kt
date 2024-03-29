package online.swiftlift.swiftlift.controller

import online.swiftlift.swiftlift.model.dto.exercise.ExerciseAddBindingModel
import online.swiftlift.swiftlift.model.dto.exercise.ExerciseDTO
import online.swiftlift.swiftlift.service.ExerciseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/{name}")
    fun getExercise(@PathVariable name: String): ResponseEntity<ExerciseDTO> =
        ResponseEntity.ok(exerciseService.findByName(name))

    @PatchMapping("/{name}")
    fun changeExercise(@RequestBody exerciseAddBindingModel: ExerciseAddBindingModel): ResponseEntity<ExerciseDTO> =
        ResponseEntity.ok(exerciseService.changeExercise(exerciseAddBindingModel))

    @DeleteMapping("/delete/{name}")
    fun deleteExercise(@PathVariable name: String): ResponseEntity<Boolean> =
        ResponseEntity.ok(exerciseService.deleteExercise(name))

    @GetMapping("/all")
    fun allExercises(): ResponseEntity<Set<ExerciseDTO>> =
        ResponseEntity.ok(exerciseService.getAll())
}