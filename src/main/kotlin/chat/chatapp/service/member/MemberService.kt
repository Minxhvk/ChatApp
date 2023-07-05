package chat.chatapp.service.member

import chat.chatapp.domain.member.Member
import chat.chatapp.domain.member.MemberRepository
import chat.chatapp.dto.member.request.UserLoginRequest
import chat.chatapp.dto.member.request.UserSignUpRequest
import chat.chatapp.exception.BizException
import chat.chatapp.exception.BizResponseCode
import chat.chatapp.security.provider.JwtAuthenticationProvider
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtAuthenticationProvider: JwtAuthenticationProvider,
) {

    @Transactional
    fun createUser(request: UserSignUpRequest): String {

        memberRepository.findUserByEmail(request.email)?.let { throw BizException(BizResponseCode.DUPLICATE_EMAIL) }

        val newMember = Member(
            name = request.name,
            email = request.email,
            password = passwordEncoder.encode(request.password),
            mobile = request.mobile
        )

        memberRepository.save(newMember)

        return jwtAuthenticationProvider.generateToken(newMember)
    }

    @Transactional
    fun login(request: UserLoginRequest): String {

        val findMember = memberRepository.findUserByEmail(request.email)
            ?: throw BizException(BizResponseCode.USER_NOT_FOUND)

        if (!passwordEncoder.matches(request.password, findMember.password)) {
            throw BizException(BizResponseCode.INVALID_PASSWORD)
        }

        return jwtAuthenticationProvider.generateToken(findMember)
    }


    fun isExistsEmail(email: String): Boolean {

        memberRepository.findUserByEmail(email)
            ?.let { return true }
            ?: return false
    }

    private fun userOf(member: Member): UserDetails {
        return User.builder()
            .username(member.email)
            .password(member.password)
            .roles()
            .build()
    }
}