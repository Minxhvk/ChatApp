package chat.chatapp.service.chatRoom

import chat.chatapp.domain.chatRoom.ChatRoom
import chat.chatapp.domain.chatRoom.ChatRoomRepository
import chat.chatapp.dto.chatRoom.request.ChatRoomCreateRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ChatRoomService(
    private val chatRoomRepository: ChatRoomRepository,
) {

    @Transactional
    fun createChatRoom(request: ChatRoomCreateRequest) {

        val newChatRoom = ChatRoom(members=request.users)
        chatRoomRepository.save(newChatRoom)
    }
}