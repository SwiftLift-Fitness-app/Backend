package online.swiftlift.swiftlift.model.entity.diet

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import online.swiftlift.swiftlift.model.entity.BaseEntity
import online.swiftlift.swiftlift.model.entity.DayEntity

@Entity
@Table(name = "diets")
class DietEntity(
    @Column(name = "name") val name: String = "",
//    @ManyToMany val days: Set<DayEntity> = setOf(),
    @ManyToMany var meals: List<MealEntity> = listOf(),
) : BaseEntity()