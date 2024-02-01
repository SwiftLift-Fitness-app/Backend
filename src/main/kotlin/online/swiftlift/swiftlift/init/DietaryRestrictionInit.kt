package online.swiftlift.swiftlift.init

import online.swiftlift.swiftlift.model.enum.DietaryRestriction
import online.swiftlift.swiftlift.model.enum.GenderType
import online.swiftlift.swiftlift.service.DietaryRestrictionService
import online.swiftlift.swiftlift.service.GenderService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DietaryRestrictionInit(private val dietaryRestrictionService: DietaryRestrictionService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (dietaryRestrictionService.isEmpty()) {
            for (restriction in DietaryRestriction.entries) {
                dietaryRestrictionService.addDietaryRestriction(restriction)
            }
        }
    }
}