package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.IngredientNotFoundException
import online.swiftlift.swiftlift.exception.MealNotFoundException
import online.swiftlift.swiftlift.model.dto.meal.IngredientDTO
import online.swiftlift.swiftlift.model.dto.meal.MealDTO
import online.swiftlift.swiftlift.model.entity.diet.MealAddBindingModel
import online.swiftlift.swiftlift.model.entity.diet.MealEntity
import online.swiftlift.swiftlift.model.enum.DietaryRestriction
import online.swiftlift.swiftlift.repository.IngredientRepository
import online.swiftlift.swiftlift.repository.MealRepository
import online.swiftlift.swiftlift.service.IngredientService
import online.swiftlift.swiftlift.service.MealService
import org.springframework.stereotype.Service

@Service
class MealServiceImpl(
    private val mealRepository: MealRepository,
    private val ingredientRepository: IngredientRepository,
) : MealService {

    override fun getAll(): List<MealDTO> =
        mealRepository.findAll()
            .map { it.toDTO() }

    override fun addMeal(mealAddBindingModel: MealAddBindingModel): MealDTO =
        mealRepository.save(
            MealEntity(
                mealAddBindingModel.name,
                mealAddBindingModel.description,
                mealAddBindingModel.ingredients
                    .mapKeys {
                        ingredientRepository
                            .findByName(it.key.name)
                            .orElseThrow { IngredientNotFoundException(it.key.name) }
                    }
            )
        ).toDTO()


    override fun getAllByDietaryRestriction(dietaryRestriction: DietaryRestriction) =
        getAll()
            .filter { it.getDietaryRestrictions().contains(dietaryRestriction) }

    override fun findByName(name: String) : MealDTO =
        mealRepository.findByName(name)
            ?.toDTO()
            ?: throw MealNotFoundException(name)

    override fun changeMeal(mealAddBindingModel: MealAddBindingModel): Any {
        mealRepository.findByName(mealAddBindingModel.name)
            ?.let {
                it.description = mealAddBindingModel.description
                it.ingredients = mealAddBindingModel.ingredients
                    .mapKeys { x->
                        ingredientRepository
                            .findByName(x.key.name)
                            .orElseThrow { IngredientNotFoundException(x.key.name) }
                    }
                return mealRepository.save(it).toDTO()
            }
            ?: throw MealNotFoundException(mealAddBindingModel.name)
    }

    private fun MealEntity.toDTO() =
        MealDTO(name, description,
            ingredients
                .mapKeys { x -> IngredientDTO(
                    name = x.key.name,
                    measurement = x.key.measurement.name,
                    calories = x.key.calories,
                    dietaryRestrictions = x.key.dietaryRestrictions
                        .map { y -> y.name }
                        .toSet()) })
}