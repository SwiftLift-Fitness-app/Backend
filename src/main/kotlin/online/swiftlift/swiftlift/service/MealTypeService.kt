package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.MealTypeDTO
import online.swiftlift.swiftlift.model.enum.MealType

interface MealTypeService {

    fun addMealType(mealType: MealType): MealTypeDTO

    fun getMealType(mealType: MealType): MealTypeDTO

    fun getAll(): Set<MealTypeDTO>

    fun isEmpty(): Boolean
}