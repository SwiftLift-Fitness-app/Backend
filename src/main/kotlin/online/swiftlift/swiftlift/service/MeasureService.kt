package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.meal.MeasurementDTO
import online.swiftlift.swiftlift.model.enum.Measurement

interface MeasureService {

    fun addMeasurement(name: Measurement): MeasurementDTO

    fun getAll(): List<MeasurementDTO>

    fun isEmpty(): Boolean
}