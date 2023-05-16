package chat.chatapp.dto.request.user

data class UserCreateRequest(
    val name: String,
    val password: String,
    val email: String,
    val mobile: String,
)