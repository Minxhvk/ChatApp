package chat.chatapp.domain.member

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: MongoRepository<Member, String>