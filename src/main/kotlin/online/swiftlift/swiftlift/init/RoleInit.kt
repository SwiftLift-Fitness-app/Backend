package online.swiftlift.swiftlift.init

import online.swiftlift.swiftlift.model.enum.Role
import online.swiftlift.swiftlift.service.RoleService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class RoleInit(private val roleService: RoleService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (roleService.isEmpty()) {
            for (role in Role.entries) {
                roleService.addRole(role)
            }
        }
    }
}