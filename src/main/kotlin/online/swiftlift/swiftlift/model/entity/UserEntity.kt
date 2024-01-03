package online.swiftlift.swiftlift.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import online.swiftlift.swiftlift.model.enum.GenderType

@Entity
@Table(name = "users")
class UserEntity(
    @Column(name = "username") val username: String,
    @Column(name = "password") val password: String,
    @Column(name = "email") val email: String,
    @Column(name = "first_name") val firstName: String,
    @Column(name = "last_name") val lastName: String,
    @Column(name = "age") val age: Int,
    @Column(name = "weight") val weight: Double,
    @Column(name = "gender") val gender: GenderType,
) : BaseEntity() {
    constructor() : this("", "", "", "", "", -1, -1.0, GenderType.MALE)
}