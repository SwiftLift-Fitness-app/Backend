package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.entity.workout.EquipmentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface EquipmentRepository : JpaRepository<EquipmentEntity, UUID> {
}