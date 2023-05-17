package chat.chatapp.service.user

import chat.chatapp.domain.user.User
import chat.chatapp.domain.user.UserRepository
import chat.chatapp.dto.request.user.UserCreateRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun saveUser(request: UserCreateRequest) {
        val newUser = User(
            name = request.name,
            email = request.email,
            password = request.password,
            mobile = request.mobile
        )

        userRepository.save(newUser)
    }
}