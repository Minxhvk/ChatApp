package chat.chatapp.dto.member

import chat.chatapp.domain.member.Member

data class MemberDto(
    val id: String?,
    val email: String,
    val token: String,
) {
    companion object {
        fun from(id: String?, email: String, token: String): MemberDto {
            return MemberDto(id, email, token)
        }
    }
}