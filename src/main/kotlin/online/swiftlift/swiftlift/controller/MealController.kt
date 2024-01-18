package online.swiftlift.swiftlift.controller

import online.swiftlift.swiftlift.service.MealService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/meals")
class MealController(private val mealService: MealService) {

    @GetMapping("/all")
    fun getAllMeals() =
        ResponseEntity.ok(mealService.getAll())

}