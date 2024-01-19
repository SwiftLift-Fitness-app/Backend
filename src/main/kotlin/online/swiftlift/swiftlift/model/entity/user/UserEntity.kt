package online.swiftlift.swiftlift.model.entity.user

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.entity.BaseEntity
import online.swiftlift.swiftlift.model.enum.GenderType

@Entity
@Table(name = "users")
class UserEntity(
    @Column(name = "username") val username: String = "",
    @Column(name = "password") val password: String = "",
    @Column(name = "email") val email: String = "",
    @Column(name = "first_name") val firstName: String = "",
    @Column(name = "last_name") val lastName: String = "",
    @Column(name = "age") var age: Int = 0,
    @Column(name = "weight") var weight: Double = 0.0,
    @Column(name = "height") var height: Int = 0,
    @Column(name = "gender") @Enumerated(EnumType.STRING) var gender: GenderType = GenderType.MALE,
    @ManyToMany(fetch = FetchType.EAGER) val roles: Set<RoleEntity> = mutableSetOf(),
) : BaseEntity()