package online.swiftlift.swiftlift.model.entity.workout

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import online.swiftlift.swiftlift.model.entity.BaseEntity
import online.swiftlift.swiftlift.model.enum.Equipment

@Entity
@Table(name = "equipment")
class EquipmentEntity(
    @Column(name = "name") val name: Equipment = Equipment.NONE
) : BaseEntity()