package chat.chatapp.dto.request.sign

data class UserLoginRequest(
    val email: String,
    val password: String,
)
