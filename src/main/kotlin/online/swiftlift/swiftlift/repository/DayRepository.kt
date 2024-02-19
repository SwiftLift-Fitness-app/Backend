package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.entity.DayEntity
import online.swiftlift.swiftlift.model.enum.Day
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DayRepository : JpaRepository<DayEntity, UUID> {
    fun findByName(name: Day): DayEntity?
}