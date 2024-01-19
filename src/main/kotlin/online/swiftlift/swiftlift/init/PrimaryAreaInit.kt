package online.swiftlift.swiftlift.init

import online.swiftlift.swiftlift.model.enum.PrimaryArea
import online.swiftlift.swiftlift.service.PrimaryAreaService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class PrimaryAreaInit(private val primaryAreaService: PrimaryAreaService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (primaryAreaService.isEmpty()) {
            for (primaryArea in PrimaryArea.entries) {
                primaryAreaService.addPrimaryArea(primaryArea)
            }
        }
    }
}