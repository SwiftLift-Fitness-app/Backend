package online.swiftlift.swiftlift.controller

import online.swiftlift.swiftlift.model.dto.meal.DietListDTO
import online.swiftlift.swiftlift.service.DietService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/diets")
class DietController(private val dietService: DietService) {

    @GetMapping("/all")
    fun getAllDiets() = dietService.getAllDiets()

    @GetMapping("/{name}")
    fun getDiet(@PathVariable name: String) = dietService.getDiet(name)

    @GetMapping("/list/{name}")
    fun getDietList(@PathVariable name: String) = dietService.getDietList(name)

    @PatchMapping("/{name}")
    fun updateDiet(@PathVariable name: String, diet: DietListDTO) = dietService.updateDiet(name, diet)

    @DeleteMapping("/{name}")
    fun deleteDiet(@PathVariable name: String) = dietService.deleteDiet(name)

//    @GetMapping("/diets/today")
//    fun getDietsForToday() = dietService.getDietsForToday()
}