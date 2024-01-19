package online.swiftlift.swiftlift.model.entity.user

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.entity.BaseEntity
import online.swiftlift.swiftlift.model.enum.Role

@Entity
@Table(name = "roles")
class RoleEntity(
    @Column(name = "name") @Enumerated(EnumType.STRING) val name: Role = Role.USER
) : BaseEntity()