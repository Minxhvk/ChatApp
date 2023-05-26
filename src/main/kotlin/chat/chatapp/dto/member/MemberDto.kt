package chat.chatapp.dto.member

import chat.chatapp.domain.member.Member

data class MemberDto(
    val id: String?,
    val email: String,
    val token: String,
) {
    companion object {
        fun from(member: Member, token: String): MemberDto {
            return MemberDto(member.id, member.email, token)
        }
    }
}