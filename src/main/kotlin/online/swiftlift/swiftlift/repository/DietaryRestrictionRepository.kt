package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.entity.DietaryRestrictionEntity
import online.swiftlift.swiftlift.model.enum.DietaryRestriction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface DietaryRestrictionRepository : JpaRepository<DietaryRestrictionEntity, UUID>{
    fun findByName(name: DietaryRestriction)
}