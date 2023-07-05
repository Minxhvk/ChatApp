package chat.chatapp.dto.chatRoom.request

import chat.chatapp.domain.member.Member

data class ChatRoomCreateRequest(
    val users: MutableList<Member>
)