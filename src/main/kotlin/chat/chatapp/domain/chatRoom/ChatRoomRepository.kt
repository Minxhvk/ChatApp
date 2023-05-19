package chat.chatapp.domain.chatRoom

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ChatRoomRepository: MongoRepository<ChatRoom, String> {
}