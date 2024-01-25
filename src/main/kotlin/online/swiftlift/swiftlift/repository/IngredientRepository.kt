package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.entity.diet.IngredientEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface IngredientRepository : JpaRepository<IngredientEntity, UUID> {

    fun findByName(name: String): Optional<IngredientEntity>
}