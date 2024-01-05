package online.swiftlift.swiftlift.exception

import online.swiftlift.swiftlift.model.enum.Role
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class RoleNotFoundException(name: Role?) : RuntimeException("Role ${name?.name} was not found!")
