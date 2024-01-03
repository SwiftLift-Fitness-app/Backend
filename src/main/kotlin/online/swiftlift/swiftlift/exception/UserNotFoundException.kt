package online.swiftlift.swiftlift.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException(username: String?) : RuntimeException("User with username: $username was not found!")
