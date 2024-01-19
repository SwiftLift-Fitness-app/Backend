package online.swiftlift.swiftlift.init

import online.swiftlift.swiftlift.model.enum.MealType
import online.swiftlift.swiftlift.model.enum.PrimaryArea
import online.swiftlift.swiftlift.model.enum.Role
import online.swiftlift.swiftlift.service.MealTypeService
import online.swiftlift.swiftlift.service.PrimaryAreaService
import online.swiftlift.swiftlift.service.RoleService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class MealTypeInit(private val mealTypeService: MealTypeService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (mealTypeService.isEmpty()) {
            for (mealType in MealType.entries) {
                mealTypeService.addMealType(mealType)
            }
        }
    }
}