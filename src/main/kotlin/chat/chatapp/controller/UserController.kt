package chat.chatapp.controller

import chat.chatapp.dto.request.user.UserCreateRequest
import chat.chatapp.service.user.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/")
    fun saveUser(@RequestBody request: UserCreateRequest) {
        userService.saveUser(request)
    }
}