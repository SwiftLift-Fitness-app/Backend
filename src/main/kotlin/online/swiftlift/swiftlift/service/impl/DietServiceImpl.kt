package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.DietNotFoundException
import online.swiftlift.swiftlift.exception.MealNotFoundException
import online.swiftlift.swiftlift.model.dto.meal.DietDTO
import online.swiftlift.swiftlift.model.dto.meal.DietListDTO
import online.swiftlift.swiftlift.model.dto.meal.IngredientDTO
import online.swiftlift.swiftlift.model.dto.meal.MealDTO
import online.swiftlift.swiftlift.model.entity.diet.DietEntity
import online.swiftlift.swiftlift.model.enum.Day
import online.swiftlift.swiftlift.repository.DayRepository
import online.swiftlift.swiftlift.repository.DietRepository
import online.swiftlift.swiftlift.repository.MealRepository
import online.swiftlift.swiftlift.service.DietService
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DietServiceImpl(private val dietRepository: DietRepository,
                      private val mealRepository: MealRepository,
                      private val dayRepository: DayRepository) : DietService {
    override fun addDiet(diet: DietListDTO): DietDTO =
        dietRepository.save(
            DietEntity(
                diet.name,
//                diet.days.map { dayRepository.findByName(Day.valueOf(it)) ?: throw Exception(it) }.toSet(),
                diet.meals.map {
                    mealRepository.findByName(it)
                        ?: throw MealNotFoundException(it)
                }
        )).toDTO()

    override fun getDiet(name: String): DietDTO =
        dietRepository.findByName(name)
            ?.toDTO()
            ?: throw MealNotFoundException(name)

    override fun getAllDiets(): List<DietDTO> {
        return dietRepository.findAll().map { it.toDTO() }
    }

    override fun updateDiet(name: String, diet: DietListDTO): DietDTO {
        val dietEntity = dietRepository.findByName(name)
            ?: throw DietNotFoundException(name)
        dietEntity.meals = diet.meals.map {
            mealRepository.findByName(it)
                ?: throw MealNotFoundException(it)
        }
        return dietRepository.save(dietEntity).toDTO()
    }

    override fun deleteDiet(name: String) {
        dietRepository.deleteByName(name)
    }

    override fun getDietList(name: String): DietListDTO =
        dietRepository.findByName(name)
            ?.toListDTO()
            ?: throw DietNotFoundException(name)

//    override fun getDietsForToday(): List<DietDTO> =
//        dietRepository.findByDaysContainingIgnoreCase(
//            mutableSetOf((dayRepository.findByName(Day.valueOf("Day${LocalDate.now().dayOfMonth}")) ?: throw Exception("Day${LocalDate.now().dayOfMonth}")))
//        ).map { it.toDTO() }

    private fun DietEntity.toDTO() = DietDTO(name, meals.map {
        MealDTO(it.name, it.description, it.ingredients
            .mapKeys { x -> IngredientDTO(
                x.key.name,
                x.key.measurement.name,
                x.key.calories,
                x.key.dietaryRestrictions.map { y -> y.name }.toSet()) })
    })

    private fun DietEntity.toListDTO() = DietListDTO(name,
//        days.map { it.name.name }.toSet(),
        meals.map { it.name })
}