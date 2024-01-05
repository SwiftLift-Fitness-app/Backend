package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.UserNotFoundException
import online.swiftlift.swiftlift.model.entity.RoleEntity
import online.swiftlift.swiftlift.model.entity.UserEntity
import online.swiftlift.swiftlift.repository.UserRepository
import online.swiftlift.swiftlift.service.SwiftLiftUserDetailsService
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails

class SwiftLiftUserDetailsServiceImpl(private val userRepository: UserRepository)
    : SwiftLiftUserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails =
        userRepository
            .findByUsername(username ?: "")
            .map { user -> map(user) }
            .orElseThrow { UserNotFoundException(username ?: "") }

    private fun map(user: UserEntity): UserDetails =
        User
            .withUsername(user.username)
            .password(user.password)
            .authorities(user.roles.map { role -> map(role) }.toList())
            .build()

    private fun map(role: RoleEntity): GrantedAuthority =
        SimpleGrantedAuthority(
            "ROLE_" + role.name.name
        )
}