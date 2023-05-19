package chat.chatapp.service.user

import chat.chatapp.domain.member.MemberRepository
import chat.chatapp.dto.request.member.MemberCreateRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberServiceTest @Autowired constructor(
    private val memberRepository: MemberRepository,
    private val memberService: MemberService,
) {
    @AfterEach
    fun clean() {
        memberRepository.deleteAll()
    }

    @Test
    fun saveUserTest() {
        val request = MemberCreateRequest(
            "김민혁",
            "minxhvk@gmail.com",
            "asd1234!",
            "010-0000-0000"
        )

        memberService.saveUser(request)

        val results = memberRepository.findAll()

        assertThat(results).hasSize(1)
        assertThat(results[0].id is String).isEqualTo(true)
        assertThat(results[0].name).isEqualTo("김민혁")
        assertThat(results[0].email).isEqualTo("minxhvk@gmail.com")
        assertThat(results[0].mobile).isEqualTo("010-0000-0000")
    }

    @Test
    fun saveUserFailTest() {

        val request = MemberCreateRequest(
            "김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁",
            "minxhvk@gmail.com",
            "asd1234!",
            "010-0000-0000"
        )

        val exception = assertThrows<IllegalArgumentException> {
            memberService.saveUser(request)
        }

        assertThat(exception.message).isEqualTo("이름은 40자 이내로 입력해야 합니다.")
    }
}