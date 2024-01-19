package online.swiftlift.swiftlift.util.authentication

import org.springframework.security.core.Authentication

interface AuthenticationFacade {

    fun authentication(): Authentication
}