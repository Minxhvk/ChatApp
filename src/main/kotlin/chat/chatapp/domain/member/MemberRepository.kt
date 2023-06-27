package chat.chatapp.domain.member

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MemberRepository: MongoRepository<Member, String>, JpaSpecificationExecutor<Member> {

    fun findUser(email: String?): UserDetails?

    fun findUserByEmail(email: String?): Member?
}