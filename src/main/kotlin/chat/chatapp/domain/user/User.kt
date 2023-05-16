package chat.chatapp.domain.user

import jakarta.persistence.Column
import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.validation.constraints.Email

@Document(collection = "users")
class User(

    @Id
    var id: String? = null,

    @Column
    var name: String,

    @Email
    @Column
    var email: String,

    @Column
    var mobile: String,

    @Column
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column
    var updatedAt: LocalDateTime? = null,
) {

    companion object {
        fun fixture(
            name: String = "Test",
            email: String = "minxhvk@gmail.com",
            mobile: String = "010-0000-0000",
            id: String? = null
        ): User {
            return User(
                name = name,
                email = email,
                mobile = mobile,
                id = id,
            )
        }
    }

}