package online.swiftlift.swiftlift.model.entity.workout

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.entity.BaseEntity
import online.swiftlift.swiftlift.model.enum.PrimaryArea

@Entity
@Table(name = "primary_area")
class PrimaryAreaEntity(
    @Column(name = "name") @Enumerated(EnumType.STRING) val name: PrimaryArea = PrimaryArea.CORE
) : BaseEntity()
