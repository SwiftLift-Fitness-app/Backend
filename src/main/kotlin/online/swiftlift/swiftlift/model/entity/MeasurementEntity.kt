package online.swiftlift.swiftlift.model.entity

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.enum.Measurement

@Entity
@Table(name = "measurements")
class MeasurementEntity(
    @Column(name = "name") @Enumerated(EnumType.STRING) val name: Measurement = Measurement.OTHER,
) : BaseEntity() {
}