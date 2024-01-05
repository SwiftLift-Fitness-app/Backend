package online.swiftlift.swiftlift.init

import online.swiftlift.swiftlift.model.enum.GenderType
import online.swiftlift.swiftlift.service.GenderService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class GenderInit(private val genderService: GenderService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (genderService.isEmpty()) {
            for (genderType in GenderType.entries) {
                genderService.addGender(genderType)
            }
        }
    }
}