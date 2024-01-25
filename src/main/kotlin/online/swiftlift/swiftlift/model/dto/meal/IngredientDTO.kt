package online.swiftlift.swiftlift.model.dto.meal

import online.swiftlift.swiftlift.model.enum.DietaryRestriction

data class IngredientDTO(
    val name: String,
    val measurement: String,
    val dietaryRestrictions: Set<DietaryRestriction>
)