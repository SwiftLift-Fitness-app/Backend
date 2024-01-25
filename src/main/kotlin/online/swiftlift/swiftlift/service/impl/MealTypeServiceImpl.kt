package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.MealTypeNotFoundException
import online.swiftlift.swiftlift.model.dto.meal.MealTypeDTO
import online.swiftlift.swiftlift.model.entity.diet.MealTypeEntity
import online.swiftlift.swiftlift.model.enum.MealType
import online.swiftlift.swiftlift.repository.MealTypeRepository
import online.swiftlift.swiftlift.service.MealTypeService
import org.springframework.stereotype.Service

@Service
class MealTypeServiceImpl(private val mealTypeRepository: MealTypeRepository) : MealTypeService {
    override fun addMealType(mealType: MealType) =
            mealTypeRepository
            .save(MealTypeEntity(mealType)).toDTO()

    override fun getMealType(mealType: MealType): MealTypeDTO =
            mealTypeRepository
                .findByName(mealType)
                .orElseThrow { MealTypeNotFoundException(mealType.name) }

    override fun getAll(): Set<MealTypeDTO> =
        mealTypeRepository
            .findAll()
            .map { it.toDTO() }
            .toSet()
    override fun isEmpty(): Boolean =
        mealTypeRepository.count() == 0L

    private fun MealTypeEntity.toDTO() =
        MealTypeDTO(name.toString())
}