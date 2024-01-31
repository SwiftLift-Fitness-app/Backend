package online.swiftlift.swiftlift.controller

import online.swiftlift.swiftlift.model.entity.diet.MealAddBindingModel
import online.swiftlift.swiftlift.model.enum.DietaryRestriction
import online.swiftlift.swiftlift.service.MealService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/all/{dietaryRestriction}")
    fun getAllMealsByDietaryRestriction(@PathVariable dietaryRestriction: String) =
        ResponseEntity.ok(mealService.getAllByDietaryRestriction(DietaryRestriction.valueOf(dietaryRestriction.uppercase())))

    @GetMapping("/{name}")
    fun getMeal(@PathVariable name: String) =
        ResponseEntity.ok(mealService.findByName(name))

    @PatchMapping("/{name}")
    fun updateMeal(@PathVariable name: String, @RequestBody mealAddBindingModel: MealAddBindingModel) =
        ResponseEntity.ok(mealService.changeMeal(mealAddBindingModel))
}