package chat.chatapp.domain.chatRoom

import chat.chatapp.domain.PrimaryKeyEntity
import chat.chatapp.domain.user.User
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("chat_room")
class ChatRoom(
    users: MutableList<User>
): PrimaryKeyEntity() {

    @DBRef
    @Field("users")
    var users = users
        private set
}