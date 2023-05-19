package chat.chatapp.dto.request.chatRoom

import chat.chatapp.domain.member.Member

data class ChatRoomCreateRequest(
    val users: MutableList<Member>
)