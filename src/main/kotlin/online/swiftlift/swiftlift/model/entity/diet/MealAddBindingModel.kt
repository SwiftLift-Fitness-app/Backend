package online.swiftlift.swiftlift.model.entity.diet

import online.swiftlift.swiftlift.model.dto.meal.IngredientDTO

data class MealAddBindingModel(
    val name: String,
    val description: String,
    val ingredients: Map<IngredientDTO, Double>,
)
