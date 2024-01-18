package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.MealDTO
import online.swiftlift.swiftlift.model.enum.DietaryRestriction

interface MealService {
    fun getAll(): List<MealDTO>

    fun getAllByDietaryRestriction(dietaryRestriction: DietaryRestriction): List<MealDTO>

    fun findByName(name: String): MealDTO
}