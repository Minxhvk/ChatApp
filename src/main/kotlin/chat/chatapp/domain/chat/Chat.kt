package chat.chatapp.domain.chat

import chat.chatapp.domain.PrimaryKeyEntity
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("chat")
class Chat(
    chatRoomId: String,
    msg: String,
    senderId: String,
): PrimaryKeyEntity() {

    @Field("chat_room_id")
    var chatRoomId = chatRoomId
        private set

    @Field("msg")
    var msg = msg
        private set

    @Field("sender_id")
    var senderId = senderId
        private set

}