package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.model.entity.diet.DietaryRestrictionDTO
import online.swiftlift.swiftlift.model.entity.diet.DietaryRestrictionEntity
import online.swiftlift.swiftlift.model.enum.DietaryRestriction
import online.swiftlift.swiftlift.repository.DietaryRestrictionRepository
import online.swiftlift.swiftlift.service.DietaryRestrictionService
import org.springframework.stereotype.Service

@Service
class DietaryRestrictionServiceImpl(private val dietaryRestrictionRepository: DietaryRestrictionRepository) : DietaryRestrictionService {
    override fun addDietaryRestriction(name: DietaryRestriction) =
        dietaryRestrictionRepository.save(
            DietaryRestrictionEntity(
                name = name
            )
        ).toDTO()

    override fun getAll(): List<DietaryRestrictionDTO> =
        dietaryRestrictionRepository.findAll().map { it.toDTO() }

    override fun isEmpty(): Boolean =
        dietaryRestrictionRepository.count() == 0L

    private fun DietaryRestrictionEntity.toDTO() =
        DietaryRestrictionDTO(
            name = name.name
        )
}