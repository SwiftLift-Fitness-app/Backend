package online.swiftlift.swiftlift.util.authentication

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class AuthenticationFacadeImpl : AuthenticationFacade {
    override fun authentication(): Authentication =
        SecurityContextHolder.getContext().authentication
}