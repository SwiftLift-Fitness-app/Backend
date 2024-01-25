package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.meal.IngredientDTO

interface IngredientService {

    fun addIngredient(ingredientDTO: IngredientDTO): IngredientDTO

    fun findByName(name: String): IngredientDTO

    fun getAll(): List<IngredientDTO>
}