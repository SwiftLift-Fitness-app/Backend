package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.entity.DayEntity
import online.swiftlift.swiftlift.model.entity.diet.DietEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface DietRepository : JpaRepository<DietEntity, UUID> {

    fun findByName(name: String): DietEntity?

    fun deleteByName(name: String)

    fun findByDaysContainingIgnoreCase(days: MutableSet<DayEntity>): Set<DietEntity>
}