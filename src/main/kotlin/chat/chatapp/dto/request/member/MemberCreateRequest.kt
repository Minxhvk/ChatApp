package chat.chatapp.dto.request.member

data class MemberCreateRequest(
    val name: String,
    val email: String,
    val password: String,
    val mobile: String,
)