package online.swiftlift.swiftlift.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class MealTypeNotFoundException(name: String?) : RuntimeException("Meal type $name was not found!")
