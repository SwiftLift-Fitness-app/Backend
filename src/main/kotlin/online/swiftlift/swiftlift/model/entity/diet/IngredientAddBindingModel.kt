package online.swiftlift.swiftlift.model.entity.diet

data class IngredientAddBindingModel(
    val name: String,
    val measurement: String,
    val dietaryRestrictions: Set<String>
)