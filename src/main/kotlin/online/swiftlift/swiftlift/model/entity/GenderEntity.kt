package online.swiftlift.swiftlift.model.entity

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.enum.GenderType

@Entity
@Table(name = "genders")
class GenderEntity(
    @Column(name = "type") @Enumerated(EnumType.STRING) val type: GenderType = GenderType.MALE
) : BaseEntity()