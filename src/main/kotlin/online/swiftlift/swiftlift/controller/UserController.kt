package online.swiftlift.swiftlift.controller

import online.swiftlift.swiftlift.model.dto.user.UserDTO
import online.swiftlift.swiftlift.model.dto.user.UserLoginBindingModel
import online.swiftlift.swiftlift.model.dto.user.UserRegisterBindingModel
import online.swiftlift.swiftlift.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @GetMapping("/all")
    fun getAll() = ResponseEntity.ok(userService.getAll())

    @PostMapping("/register")
    fun register(@RequestBody userRegisterBindingModel: UserRegisterBindingModel): ResponseEntity<UserDTO> {

        return ResponseEntity.ok(userService.register(userRegisterBindingModel))
    }

    @PostMapping("/login")
    fun login(@RequestBody userLoginBindingModel: UserLoginBindingModel) =
        ResponseEntity.ok(userService.login(userLoginBindingModel))
}