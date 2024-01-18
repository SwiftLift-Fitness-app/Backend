package online.swiftlift.swiftlift.exception

import online.swiftlift.swiftlift.model.enum.GenderType
import online.swiftlift.swiftlift.model.enum.Role
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ExerciseNotFoundException(name: String?) : RuntimeException("Gender $name was not found!")
