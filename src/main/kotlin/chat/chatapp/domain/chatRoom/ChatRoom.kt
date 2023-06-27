package chat.chatapp.domain.chatRoom

import chat.chatapp.domain.BaseTime
import chat.chatapp.domain.member.Member
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("chat_room")
class ChatRoom(

    @Id
    val id: Long? = null,

    val members: MutableList<Member>
): BaseTime() {

}