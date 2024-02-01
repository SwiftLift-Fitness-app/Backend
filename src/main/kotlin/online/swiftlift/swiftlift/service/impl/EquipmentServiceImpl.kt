package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.model.dto.exercise.EquipmentDTO
import online.swiftlift.swiftlift.model.entity.workout.EquipmentEntity
import online.swiftlift.swiftlift.model.enum.Equipment
import online.swiftlift.swiftlift.repository.EquipmentRepository
import online.swiftlift.swiftlift.service.EquipmentService
import org.springframework.stereotype.Service

@Service
class EquipmentServiceImpl(private val equipmentRepository: EquipmentRepository) : EquipmentService {
    override fun addEquipment(name: Equipment): EquipmentDTO =
        equipmentRepository.save(
            EquipmentEntity(
                name = name
            )
        ).toDTO()

    override fun getAll(): List<EquipmentDTO> =
        equipmentRepository.findAll().map { it.toDTO() }

    override fun isEmpty(): Boolean =
        equipmentRepository.count() == 0L

    private fun EquipmentEntity.toDTO() =
        EquipmentDTO(
            name = name.name
    )
}