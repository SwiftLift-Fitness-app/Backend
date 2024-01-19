package online.swiftlift.swiftlift.model.entity.diet

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import online.swiftlift.swiftlift.model.entity.BaseEntity
import online.swiftlift.swiftlift.model.enum.DietaryRestriction

@Entity
@Table(name = "dietary_restictions")
class DietaryRestrictionEntity(
    @Column(name = "name") val name: DietaryRestriction = DietaryRestriction.NONE
) : BaseEntity()