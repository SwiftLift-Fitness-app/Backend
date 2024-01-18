package online.swiftlift.swiftlift.model.dto

import online.swiftlift.swiftlift.model.enum.DietaryRestriction

data class IngredientDTO(
    val name: String,
    val dietaryRestrictions: Set<DietaryRestriction>
)