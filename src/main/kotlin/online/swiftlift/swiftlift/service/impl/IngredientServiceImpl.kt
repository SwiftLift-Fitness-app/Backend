package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.DietaryRestrictionNotFoundException
import online.swiftlift.swiftlift.exception.DietaryRestrictionsNotFoundException
import online.swiftlift.swiftlift.model.dto.meal.IngredientDTO
import online.swiftlift.swiftlift.model.entity.diet.IngredientEntity
import online.swiftlift.swiftlift.model.enum.Measurement
import online.swiftlift.swiftlift.repository.DietaryRestrictionRepository
import online.swiftlift.swiftlift.repository.IngredientRepository
import online.swiftlift.swiftlift.service.IngredientService
import org.springframework.stereotype.Service

@Service
class IngredientServiceImpl(
    private val ingredientRepository: IngredientRepository,
    private val dietaryRestrictionRepository: DietaryRestrictionRepository,
) : IngredientService {
    override fun addIngredient(ingredientDTO: IngredientDTO): IngredientDTO =
        ingredientRepository.save(
            IngredientEntity(
                name = ingredientDTO.name,
                measurement = Measurement.valueOf(ingredientDTO.measurement.uppercase()),
                calories = ingredientDTO.calories,
                dietaryRestrictions = dietaryRestrictionRepository
                    .findAllByNameIn(ingredientDTO.dietaryRestrictions)
                    .orElseThrow { DietaryRestrictionsNotFoundException() }
            )
        ).toDTO()

    override fun findByName(name: String): IngredientDTO =
        ingredientRepository.findByName(name)
            .orElseThrow { DietaryRestrictionNotFoundException(name) }
            .toDTO()

    override fun getAll(): List<IngredientDTO> =
        ingredientRepository.findAll()
            .map { it.toDTO() }
}

private fun IngredientEntity.toDTO() =
    IngredientDTO(name, measurement.name, calories, dietaryRestrictions.map { it.name }.toSet())
