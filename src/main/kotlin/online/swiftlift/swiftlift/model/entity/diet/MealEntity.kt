package online.swiftlift.swiftlift.model.entity.diet

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.entity.BaseEntity

@Entity
@Table(name = "meals")
class MealEntity(
    @Column(name = "name") val name: String = "",
    @Column(name = "description") val description: String = "",
    @ElementCollection
    @JoinTable(
        name = "meals_ingredients",
        joinColumns = [ JoinColumn(name = "meal_id") ],
    )
    @MapKeyJoinColumn(name = "ingredient_id")
    @Column(name = "amount")
        val ingredients: Map<IngredientEntity, Double> = mutableMapOf()
) : BaseEntity()