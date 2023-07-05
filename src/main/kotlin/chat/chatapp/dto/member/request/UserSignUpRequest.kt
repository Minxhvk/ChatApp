package chat.chatapp.dto.member.request

data class UserSignUpRequest(
    val name: String,
    val email: String,
    val password: String,
    val mobile: String,
)