package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.entity.user.UserEntity
import online.swiftlift.swiftlift.model.entity.workout.RoutineEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface RoutineRepository : JpaRepository<RoutineEntity, UUID> {
    fun findByName(name: String): RoutineEntity?
    fun findByUser(user: UserEntity): List<RoutineEntity?>?
}