package online.swiftlift.swiftlift.model.entity.diet

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.entity.BaseEntity
import online.swiftlift.swiftlift.model.entity.MeasurementEntity
import online.swiftlift.swiftlift.model.enum.Measurement

@Entity
@Table(name = "ingredients")
class IngredientEntity(
    @Column(name = "name") val name: String = "",
    @Column(name = "measurement") @Enumerated(EnumType.STRING) val measurement: Measurement = Measurement.OTHER,
    @Column(name = "calories") val calories: Int = 0,
    @ManyToMany val dietaryRestrictions: Set<DietaryRestrictionEntity> = mutableSetOf()
) : BaseEntity()