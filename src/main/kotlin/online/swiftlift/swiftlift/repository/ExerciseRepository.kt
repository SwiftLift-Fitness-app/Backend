package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.dto.exercise.ExerciseDTO
import online.swiftlift.swiftlift.model.entity.ExerciseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface ExerciseRepository : JpaRepository<ExerciseEntity, UUID> {

    fun findByName(name: String): Optional<ExerciseDTO>
}