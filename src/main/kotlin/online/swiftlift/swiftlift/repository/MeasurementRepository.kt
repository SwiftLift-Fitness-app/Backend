package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.entity.MeasurementEntity
import online.swiftlift.swiftlift.model.enum.Measurement
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface MeasurementRepository : JpaRepository<MeasurementEntity, UUID> {

    fun findByName(name: Measurement): Optional<MeasurementEntity>
}