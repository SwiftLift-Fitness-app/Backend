package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.MealNotFoundException
import online.swiftlift.swiftlift.model.dto.IngredientDTO
import online.swiftlift.swiftlift.model.dto.MealDTO
import online.swiftlift.swiftlift.model.entity.diet.MealEntity
import online.swiftlift.swiftlift.model.enum.DietaryRestriction
import online.swiftlift.swiftlift.repository.MealRepository
import online.swiftlift.swiftlift.service.MealService
import org.springframework.stereotype.Service

@Service
class MealServiceImpl(private val mealRepository: MealRepository) : MealService {

    override fun getAll(): List<MealDTO> =
        mealRepository.findAll()
            .map { map(it) }

    override fun getAllByDietaryRestriction(dietaryRestriction: DietaryRestriction) =
        getAll()
            .filter { it.getDietaryRestrictions().contains(dietaryRestriction) }

    override fun findByName(name: String) : MealDTO =
        mealRepository.findByName(name)
            .orElseThrow { MealNotFoundException(name) }

    private fun map(entity: MealEntity) =
        MealDTO(entity.name, entity.description,
            entity.ingredients
                .mapKeys { x -> IngredientDTO(x.key.name,
                    x.key.dietaryRestrictions
                        .map { y -> y.name }
                        .toSet()) })
}