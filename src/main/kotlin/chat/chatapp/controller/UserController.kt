package chat.chatapp.controller

import chat.chatapp.service.user.UserService
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {
}