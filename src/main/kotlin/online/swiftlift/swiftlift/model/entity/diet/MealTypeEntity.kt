package online.swiftlift.swiftlift.model.entity.diet

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.entity.BaseEntity
import online.swiftlift.swiftlift.model.enum.MealType

@Entity
@Table(name = "meal_types")
class MealTypeEntity(
    @Column(name = "name") @Enumerated(EnumType.STRING) val name: MealType = MealType.OTHER
) : BaseEntity()