package chat.chatapp.domain.member

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MemberRepository: MongoRepository<Member, String> {

    fun findByEmail(email: String?): Member?
}