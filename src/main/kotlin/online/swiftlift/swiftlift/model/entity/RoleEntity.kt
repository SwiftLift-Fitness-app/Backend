package online.swiftlift.swiftlift.model.entity

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.enum.Role

@Entity
@Table(name = "roles")
class RoleEntity(
    @Column(name = "name") @Enumerated(EnumType.STRING) val name: Role = Role.USER
) : BaseEntity()