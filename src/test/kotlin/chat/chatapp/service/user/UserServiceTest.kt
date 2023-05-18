package chat.chatapp.service.user

import chat.chatapp.domain.user.UserRepository
import chat.chatapp.dto.request.user.UserCreateRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService,
) {
    @AfterEach
    fun clean() {
        userRepository.deleteAll()
    }

    @Test
    fun saveUserTest() {
        val request = UserCreateRequest(
            "김민혁",
            "minxhvk@gmail.com",
            "asd1234!",
            "010-0000-0000"
        )

        userService.saveUser(request)

        val results = userRepository.findAll()

        assertThat(results).hasSize(1)
        assertThat(results[0].id is String).isEqualTo(true)
        assertThat(results[0].name).isEqualTo("김민혁")
        assertThat(results[0].email).isEqualTo("minxhvk@gmail.com")
        assertThat(results[0].mobile).isEqualTo("010-0000-0000")
    }

    @Test
    fun saveUserFailTest() {

        val request = UserCreateRequest(
            "김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁김민혁",
            "minxhvk@gmail.com",
            "asd1234!",
            "010-0000-0000"
        )

        val exception = assertThrows<IllegalArgumentException> {
            userService.saveUser(request)
        }

        assertThat(exception.message).isEqualTo("이름은 40자 이내로 입력해야 합니다.")
    }
}