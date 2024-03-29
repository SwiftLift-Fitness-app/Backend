package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.GenderNotFoundException
import online.swiftlift.swiftlift.model.dto.user.GenderDTO
import online.swiftlift.swiftlift.model.entity.user.GenderEntity
import online.swiftlift.swiftlift.model.enum.GenderType
import online.swiftlift.swiftlift.repository.GenderRepository
import online.swiftlift.swiftlift.service.GenderService
import org.springframework.stereotype.Service

@Service
class GenderServiceImpl(private val genderRepository: GenderRepository) : GenderService {

    override fun addGender(gender: GenderType) {
        genderRepository.save(GenderEntity(gender))
    }

    override fun findGender(gender: GenderType): GenderDTO =
        genderRepository.findByType(gender)
            .map { it.toDTO() }
            .orElseThrow { GenderNotFoundException(gender) }

    private fun GenderEntity.toDTO() =
        GenderDTO(type)

    override fun isEmpty(): Boolean =
        genderRepository.count() == 0L
}