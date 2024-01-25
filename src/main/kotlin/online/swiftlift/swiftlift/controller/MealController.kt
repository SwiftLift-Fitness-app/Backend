package online.swiftlift.swiftlift.controller

import online.swiftlift.swiftlift.model.entity.diet.MealAddBindingModel
import online.swiftlift.swiftlift.service.MealService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/meals")
class MealController(private val mealService: MealService) {

    @PostMapping("/add")
    fun addMeal(@RequestBody mealAddBindingModel: MealAddBindingModel) =
        ResponseEntity.ok(mealService.addMeal(mealAddBindingModel))

    @GetMapping("/all")
    fun getAllMeals() =
        ResponseEntity.ok(mealService.getAll())

}