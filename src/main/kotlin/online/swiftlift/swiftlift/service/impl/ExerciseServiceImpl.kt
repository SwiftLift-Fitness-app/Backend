package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.ExerciseNotFoundException
import online.swiftlift.swiftlift.model.dto.exercise.ExerciseAddBindingModel
import online.swiftlift.swiftlift.model.dto.exercise.ExerciseDTO
import online.swiftlift.swiftlift.model.entity.workout.ExerciseEntity
import online.swiftlift.swiftlift.repository.ExerciseRepository
import online.swiftlift.swiftlift.service.ExerciseService
import org.springframework.stereotype.Service

@Service
class ExerciseServiceImpl(private val exerciseRepository: ExerciseRepository) : ExerciseService {

    override fun addExercise(exercise: ExerciseAddBindingModel): ExerciseDTO {
        val entity = exerciseRepository.save(
            ExerciseEntity(
                exercise.name,
                exercise.description
            )
        )

        return ExerciseDTO(entity.name, entity.description, entity.created)
    }

    override fun findByName(name: String): ExerciseDTO =
        exerciseRepository.findByName(name)
            .orElseThrow { ExerciseNotFoundException(name) }
}