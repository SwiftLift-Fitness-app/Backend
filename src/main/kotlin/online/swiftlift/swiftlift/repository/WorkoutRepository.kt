package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.entity.workout.WorkoutEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface WorkoutRepository : JpaRepository<WorkoutEntity, UUID> {

    fun findByName(name: String): WorkoutEntity?

    fun deleteByName(name: String)
}