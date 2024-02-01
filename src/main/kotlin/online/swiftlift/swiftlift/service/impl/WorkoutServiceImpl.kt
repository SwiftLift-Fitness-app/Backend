package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.ExerciseNotFoundException
import online.swiftlift.swiftlift.exception.WorkoutNotFoundException
import online.swiftlift.swiftlift.model.dto.exercise.ExerciseDTO
import online.swiftlift.swiftlift.model.dto.exercise.WorkoutAddBindingModel
import online.swiftlift.swiftlift.model.dto.exercise.WorkoutDTO
import online.swiftlift.swiftlift.model.entity.workout.ExerciseEntity
import online.swiftlift.swiftlift.model.entity.workout.WorkoutEntity
import online.swiftlift.swiftlift.model.enum.PrimaryArea
import online.swiftlift.swiftlift.repository.ExerciseRepository
import online.swiftlift.swiftlift.repository.WorkoutRepository
import online.swiftlift.swiftlift.service.PrimaryAreaService
import online.swiftlift.swiftlift.service.WorkoutService
import org.springframework.stereotype.Service

@Service
class WorkoutServiceImpl(private val workoutRepository: WorkoutRepository,
                         private val exerciseRepository: ExerciseRepository,
                         private val primaryAreaService: PrimaryAreaService) : WorkoutService {
    override fun getAll(): List<WorkoutDTO> =
        workoutRepository.findAll().map { it.toDTO() }

    override fun getByName(name: String): WorkoutDTO =
        workoutRepository.findByName(name)
            ?.toDTO()
            ?: throw WorkoutNotFoundException(name)

    override fun addWorkout(workoutAddBindingModel: WorkoutAddBindingModel): WorkoutDTO =
        workoutRepository
            .save(WorkoutEntity(
                exercises = workoutAddBindingModel.exercises.mapKeys { exerciseRepository.findByName(it.key)
                    ?: throw ExerciseNotFoundException(it.key) },
                primaryArea = PrimaryArea.valueOf(workoutAddBindingModel.primaryArea)
            ))
            .toDTO()
    override fun changeWorkout(workoutAddBindingModel: WorkoutAddBindingModel): WorkoutDTO {
        val workout = workoutRepository.findByName(workoutAddBindingModel.primaryArea)
            ?: throw WorkoutNotFoundException(workoutAddBindingModel.primaryArea)
        workout.name = workoutAddBindingModel.name
        workout.exercises = workoutAddBindingModel.exercises.mapKeys { exerciseRepository.findByName(it.key)
            ?: throw ExerciseNotFoundException(it.key) }
        workout.primaryArea = PrimaryArea.valueOf(workoutAddBindingModel.primaryArea)
        return workoutRepository.save(workout).toDTO()
    }


    override fun deleteWorkout(name: String) =
        workoutRepository.deleteByName(name)

    private fun WorkoutEntity.toDTO() =
        WorkoutDTO(
            name = name,
            exercises = exercises.mapKeys { it.key.toDTO() },
            primaryArea = primaryArea.name,
        )

    private fun ExerciseEntity.toDTO() =
        ExerciseDTO(
            name = name,
            description = description,
            equipment = equipment.name,
            area = primaryAreaService.getPrimaryAreaByName(name)
        )
}