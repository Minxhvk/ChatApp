package chat.chatapp.dto.request.sign

data class UserSignUpRequest(
    val name: String,
    val email: String,
    val password: String,
    val mobile: String,
)