package chat.chatapp.service.member

import chat.chatapp.domain.member.Member
import chat.chatapp.domain.member.MemberRepository
import chat.chatapp.dto.member.MemberDto
import chat.chatapp.dto.request.sign.LoginRequest
import chat.chatapp.dto.request.sign.SignUpRequest
import chat.chatapp.exception.InvalidEmailException
import chat.chatapp.exception.MemberNotFoundException
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
    fun saveUser(request: SignUpRequest): MemberDto {

        if(!isValidEmail(request.email)) {
            throw InvalidEmailException("Duplicated Email")
        }

        val newMember = Member(
            name = request.name,
            email = request.email,
            password = passwordEncoder.encode(request.password),
            mobile = request.mobile
        )

        memberRepository.save(newMember)

        val token = jwtAuthenticationProvider.generateToken(userOf(newMember))

        return MemberDto.from(newMember, token)
    }

    @Transactional
    fun login(request: LoginRequest): String {
        val findMember = memberRepository.findByEmail(request.email) ?: throw MemberNotFoundException("User Does Not Exists")

        return "test"
    }


    fun isValidEmail(email: String): Boolean {

        // 존재할 경우
        memberRepository.findByEmail(email)?.let { return false }

        return true
    }

    private fun userOf(member: Member): UserDetails {
        return User.builder()
            .username(member.email)
            .password(member.password)
            .roles()
            .build()
    }
}