package chat.chatapp.dto.request.user

data class UserCreateRequest(
    val name: String,
    val email: String,
    val password: String,
    val mobile: String,
)