package chat.chatapp.service.user

import chat.chatapp.domain.member.Member
import chat.chatapp.domain.member.MemberRepository
import chat.chatapp.dto.request.member.MemberCreateRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {

    @Transactional
    fun saveUser(request: MemberCreateRequest) {
        val newMember = Member(
            name = request.name,
            email = request.email,
            password = request.password,
            mobile = request.mobile
        )

        memberRepository.save(newMember)
    }
}