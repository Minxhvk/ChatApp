package chat.chatapp.domain.chatRoom

import chat.chatapp.domain.PrimaryKeyEntity
import chat.chatapp.domain.member.Member
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("chat_room")
class ChatRoom(
    members: MutableList<Member>
): PrimaryKeyEntity() {

    @DBRef
    @Field("members")
    var members = members
        private set
}