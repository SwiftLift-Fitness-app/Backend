package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.user.RoleDTO
import online.swiftlift.swiftlift.model.enum.Role

interface RoleService {

    fun addRole(role: Role)

    fun findRole(role: Role): RoleDTO

    fun isEmpty(): Boolean
}