package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.entity.diet.DietaryRestrictionDTO
import online.swiftlift.swiftlift.model.enum.DietaryRestriction

interface DietaryRestrictionService {

    fun addDietaryRestriction(name: DietaryRestriction): DietaryRestrictionDTO

    fun getAll(): List<DietaryRestrictionDTO>

    fun isEmpty(): Boolean
}