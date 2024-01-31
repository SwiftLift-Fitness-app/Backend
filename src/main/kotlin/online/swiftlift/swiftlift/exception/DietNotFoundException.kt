package online.swiftlift.swiftlift.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class DietNotFoundException(name: String?) : RuntimeException("Diet $name was not found!")
