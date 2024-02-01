package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.model.dto.meal.MeasurementDTO
import online.swiftlift.swiftlift.model.entity.MeasurementEntity
import online.swiftlift.swiftlift.model.enum.Measurement
import online.swiftlift.swiftlift.repository.MeasurementRepository
import online.swiftlift.swiftlift.service.MeasureService
import org.springframework.stereotype.Service

@Service
class MeasureServiceImpl(private val measurementRepository: MeasurementRepository) : MeasureService {
    override fun addMeasurement(name: Measurement) =
        measurementRepository.save(
            MeasurementEntity(
                name = name
            )
        ).toDTO()

    override fun getAll(): List<MeasurementDTO> =
        measurementRepository.findAll().map { it.toDTO() }

    override fun isEmpty(): Boolean =
        measurementRepository.count() == 0L

    private fun MeasurementEntity.toDTO() =
        MeasurementDTO(
            name = name.name
    )
}
