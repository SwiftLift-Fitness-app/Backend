package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.dto.MealDTO
import online.swiftlift.swiftlift.model.entity.MealEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface MealRepository : JpaRepository<MealEntity, UUID> {

    fun findByName(name: String): Optional<MealDTO>
}