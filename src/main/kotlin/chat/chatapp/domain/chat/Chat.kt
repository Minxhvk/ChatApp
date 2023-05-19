package chat.chatapp.domain.chat

import chat.chatapp.domain.PrimaryKeyEntity
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("chat")
class Chat(

    @Field("msg")
    var msg: String,

    @DBRef
    @Field("chat_room_id")
    var chatRoomId: String,

    @DBRef
    @Field("sender_id")
    var senderId: String,

): PrimaryKeyEntity() {

}