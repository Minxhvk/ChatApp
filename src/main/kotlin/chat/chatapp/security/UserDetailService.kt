package chat.chatapp.security

import chat.chatapp.domain.member.MemberRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailService(
    val memberRepository: MemberRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        TODO("Not yet implemented")
    }
}