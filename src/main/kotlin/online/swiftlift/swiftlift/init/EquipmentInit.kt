package online.swiftlift.swiftlift.init

import online.swiftlift.swiftlift.model.enum.Equipment
import online.swiftlift.swiftlift.model.enum.GenderType
import online.swiftlift.swiftlift.service.EquipmentService
import online.swiftlift.swiftlift.service.GenderService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class EquipmentInit(private val equipmentService: EquipmentService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (equipmentService.isEmpty()) {
            for (equipmentType in Equipment.entries) {
                equipmentService.addEquipment(equipmentType)
            }
        }
    }
}