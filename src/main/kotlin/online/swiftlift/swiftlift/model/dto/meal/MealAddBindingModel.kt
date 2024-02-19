package online.swiftlift.swiftlift.model.dto.meal

import online.swiftlift.swiftlift.model.dto.meal.IngredientDTO

data class MealAddBindingModel(
    val name: String,
    val description: String,
    val ingredients: Map<IngredientDTO, Double>,
)
