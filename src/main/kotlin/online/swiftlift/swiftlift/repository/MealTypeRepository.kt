package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.dto.meal.MealTypeDTO
import online.swiftlift.swiftlift.model.entity.diet.MealTypeEntity
import online.swiftlift.swiftlift.model.enum.MealType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface MealTypeRepository : JpaRepository<MealTypeEntity, UUID> {

    fun findByName(name: MealType): Optional<MealTypeDTO>
}