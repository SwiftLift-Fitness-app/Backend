package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.dto.meal.MealDTO
import online.swiftlift.swiftlift.model.entity.diet.MealEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface MealRepository : JpaRepository<MealEntity, UUID> {

    fun findByName(name: String): Optional<MealDTO>
}