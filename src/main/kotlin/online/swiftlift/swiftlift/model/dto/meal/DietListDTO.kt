package online.swiftlift.swiftlift.model.dto.meal

data class DietListDTO(
    val name: String,
    val days: Set<String>,
    val meals: List<String>,
)
