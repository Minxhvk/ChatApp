package chat.chatapp.dto.request.chatRoom

import chat.chatapp.domain.user.User

data class ChatRoomCreateRequest(
    val users: MutableList<User>
)