package online.swiftlift.swiftlift.model.dto.meal

import online.swiftlift.swiftlift.model.enum.DietaryRestriction

data class MealDTO(
    val name: String,
    val description: String,
    val ingredients: Map<IngredientDTO, Double>,
) {
    fun getDietaryRestrictions(): Set<DietaryRestriction> {
        val dietaryRestrictions: Set<DietaryRestriction> = mutableSetOf()
        ingredients.keys.forEach {
            dietaryRestrictions.plus(it.dietaryRestrictions)
        }
        return dietaryRestrictions
    }
}