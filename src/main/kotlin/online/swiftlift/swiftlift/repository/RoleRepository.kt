package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.entity.RoleEntity
import online.swiftlift.swiftlift.model.enum.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface RoleRepository : JpaRepository<RoleEntity, UUID> {

    fun findByName(role: Role): Optional<RoleEntity>
}