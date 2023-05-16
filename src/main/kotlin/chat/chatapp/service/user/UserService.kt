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
        val newUser = User(null, request.name, request.password, request.email, request.mobile)
        userRepository.save(newUser)
    }
}