package chat.chatapp.dto.member

import chat.chatapp.domain.member.Member

data class MemberDto(
    val id: Long?,
    val email: String,
    val token: String,
) {
    companion object {
        fun from(id: Long?, email: String, token: String): MemberDto {
            return MemberDto(id, email, token)
        }
    }
}