package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.meal.DietDTO
import online.swiftlift.swiftlift.model.dto.meal.DietListDTO

interface DietService {

    fun addDiet(diet: DietListDTO): DietDTO

    fun getDiet(name: String): DietDTO

    fun getAllDiets(): List<DietDTO>

    fun updateDiet(name: String, diet: DietListDTO): DietDTO

    fun deleteDiet(name: String)

    fun getDietList(name: String): DietListDTO
}