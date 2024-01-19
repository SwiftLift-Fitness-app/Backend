package online.swiftlift.swiftlift.model.entity.diet

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import online.swiftlift.swiftlift.model.entity.BaseEntity

@Entity
@Table(name = "ingredients")
class IngredientEntity(
    @Column(name = "name") val name: String = "",
    @ManyToMany val dietaryRestrictions: Set<DietaryRestrictionEntity> = mutableSetOf()
) : BaseEntity()