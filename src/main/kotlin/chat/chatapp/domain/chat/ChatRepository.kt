package chat.chatapp.domain.chat

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ChatRepository: MongoRepository<Chat, String> {
}