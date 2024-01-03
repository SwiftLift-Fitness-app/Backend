package online.swiftlift.swiftlift

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SwiftLiftApplication

fun main(args: Array<String>) {
	runApplication<SwiftLiftApplication>(*args)
}
