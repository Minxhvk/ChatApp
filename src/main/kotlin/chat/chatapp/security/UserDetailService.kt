package chat.chatapp.security

import chat.chatapp.domain.member.Member
import chat.chatapp.domain.member.MemberRepository
import mu.KotlinLogging
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

private val logger = KotlinLogging.logger {}

@Service
class UserDetailService(
    val memberRepository: MemberRepository
): UserDetailsService {

    @Transactional
    override fun loadUserByUsername(email: String): UserDetails {
        val member: Member =
            memberRepository.findByEmail(email) ?: throw UsernameNotFoundException("User Does Not Exists")

        logger.info { "Success find member ${member}" }

        // TEMP
        return User(member.email, member.password, null)
    }
}