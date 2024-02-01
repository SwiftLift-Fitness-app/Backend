package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.exercise.EquipmentDTO
import online.swiftlift.swiftlift.model.enum.Equipment

interface EquipmentService {

    fun addEquipment(name: Equipment): EquipmentDTO

    fun getAll(): List<EquipmentDTO>

    fun isEmpty(): Boolean
}