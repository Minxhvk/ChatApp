package chat.chatapp.controller.chatRoom

import chat.chatapp.dto.chatRoom.request.ChatRoomCreateRequest
import chat.chatapp.service.chatRoom.ChatRoomService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class ChatRoomController(
    private val chatRoomService: ChatRoomService,
) {

    @RequestMapping("/")
    fun createChatRoom(request: ChatRoomCreateRequest) {

    }

}