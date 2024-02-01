package online.swiftlift.swiftlift.init

import online.swiftlift.swiftlift.model.enum.Measurement
import online.swiftlift.swiftlift.service.MeasureService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class MeasurementInit(private val measureService: MeasureService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (measureService.isEmpty()) {
            for (measurement in Measurement.entries) {
                measureService.addMeasurement(measurement)
            }
        }
    }
}