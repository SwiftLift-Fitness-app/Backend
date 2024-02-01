package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.RoleNotFoundException
import online.swiftlift.swiftlift.model.dto.user.RoleDTO
import online.swiftlift.swiftlift.model.entity.user.RoleEntity
import online.swiftlift.swiftlift.model.enum.Role
import online.swiftlift.swiftlift.repository.RoleRepository
import online.swiftlift.swiftlift.service.RoleService
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl(private val roleRepository: RoleRepository) : RoleService {
    override fun addRole(role: Role) {
        roleRepository.save(RoleEntity(role))
    }

    override fun findRole(role: Role): RoleDTO =
        roleRepository.findByName(role)
            .map { it.toDTO() }
            .orElseThrow { RoleNotFoundException(role) }

    private fun RoleEntity.toDTO() =
        RoleDTO(name)

    override fun isEmpty() =
        roleRepository.count() == 0L
}