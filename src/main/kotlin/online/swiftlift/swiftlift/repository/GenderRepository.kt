package online.swiftlift.swiftlift.repository

import online.swiftlift.swiftlift.model.entity.GenderEntity
import online.swiftlift.swiftlift.model.enum.GenderType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface GenderRepository : JpaRepository<GenderEntity, UUID> {

    fun findByType(genderType: GenderType): Optional<GenderEntity>

}