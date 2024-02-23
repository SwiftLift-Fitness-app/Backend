package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.ExerciseNotFoundException
import online.swiftlift.swiftlift.model.dto.exercise.ExerciseAddBindingModel
import online.swiftlift.swiftlift.model.dto.exercise.ExerciseDTO
import online.swiftlift.swiftlift.model.dto.exercise.PrimaryAreaDTO
import online.swiftlift.swiftlift.model.entity.workout.ExerciseEntity
import online.swiftlift.swiftlift.model.enum.Equipment
import online.swiftlift.swiftlift.model.enum.PrimaryArea
import online.swiftlift.swiftlift.repository.ExerciseRepository
import online.swiftlift.swiftlift.service.ExerciseService
import org.springframework.stereotype.Service

@Service
class ExerciseServiceImpl(private val exerciseRepository: ExerciseRepository) : ExerciseService {

    override fun addExercise(exercise: ExerciseAddBindingModel): ExerciseDTO {
        val entity = exerciseRepository.save(
            ExerciseEntity(
                exercise.name,
                exercise.description,
                PrimaryArea.valueOf(exercise.area),
                Equipment.valueOf(exercise.equipment)
            )
        )

        return entity.toDTO()
    }

    override fun getAll(): Set<ExerciseDTO> =
        exerciseRepository.findAll().map { it.toDTO() }.toSet()

    override fun deleteExercise(name: String): Boolean {
        exerciseRepository.delete(
            exerciseRepository.findByName(name)
                ?: throw ExerciseNotFoundException(name)
        )
        return exerciseRepository.findByName(name) == null
    }

    override fun changeExercise(exerciseAddBindingModel: ExerciseAddBindingModel): ExerciseDTO {
        val entity = exerciseRepository.findByName(exerciseAddBindingModel.name)
            ?: throw ExerciseNotFoundException(exerciseAddBindingModel.name)

        entity.description = exerciseAddBindingModel.description
        entity.area = PrimaryArea.valueOf(exerciseAddBindingModel.area)
        entity.equipment = Equipment.valueOf(exerciseAddBindingModel.equipment)

        return exerciseRepository.save(entity).toDTO()
    }

    override fun findByName(name: String): ExerciseDTO =
        exerciseRepository.findByName(name)
            ?.toDTO()
            ?: throw ExerciseNotFoundException(name)

    private fun ExerciseEntity.toDTO() = ExerciseDTO(name, description, PrimaryAreaDTO(area.name), equipment.name)
}