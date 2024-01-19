package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.dto.exercise.PrimaryAreaDTO
import online.swiftlift.swiftlift.model.entity.workout.PrimaryAreaEntity
import online.swiftlift.swiftlift.model.enum.PrimaryArea
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface PrimaryAreaRepository : JpaRepository<PrimaryAreaEntity, UUID> {

    fun findByName(name: PrimaryArea): Optional<PrimaryAreaEntity>
}