package online.swiftlift.swiftlift.model.dto.meal

data class IngredientAddBindingModel(
    val name: String,
    val measurement: String,
    val dietaryRestrictions: Set<String>
)