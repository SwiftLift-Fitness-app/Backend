package online.swiftlift.swiftlift.controller

import online.swiftlift.swiftlift.model.dto.user.UserDTO
import online.swiftlift.swiftlift.model.dto.user.UserRegisterBindingModel
import online.swiftlift.swiftlift.model.dto.user.UserSurveyBindingModel
import online.swiftlift.swiftlift.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("/users")
class UsersController(val userService: UserService) {

    @GetMapping("/all")
    fun getAll() = ResponseEntity.ok(userService.getAll())

    @GetMapping("/login")
    fun login(authentication: Authentication?): ModelAndView {
        val modelAndView = ModelAndView("test")
        modelAndView.addObject("name", authentication?.name)
        return modelAndView
    }

    @GetMapping("/register")
    fun register() = ModelAndView("index")

    @PostMapping("/register")
    fun register(@RequestBody userRegisterBindingModel: UserRegisterBindingModel): ResponseEntity<UserDTO> =
        ResponseEntity.ok(userService.register(userRegisterBindingModel))

    @PatchMapping("/survey")
    fun register(@RequestBody userSurveyBindingModel: UserSurveyBindingModel): ResponseEntity<UserDTO> =
        ResponseEntity.ok(userService.submitSurvey(userSurveyBindingModel))

    @GetMapping("/profile/{username}")
    fun profileData(@PathVariable username: String) =
        userService.profileData(username)
}