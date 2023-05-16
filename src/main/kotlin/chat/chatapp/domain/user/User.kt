package chat.chatapp.domain.user

import com.querydsl.core.annotations.QueryEntity
import jakarta.persistence.*
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
@QueryEntity
@Document(collection = "users")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: String? = null,

    @Size(max=40)
    val name: String,

    @Field(name = "password")
    val password: String,

    @Email
    @Size(max=40)
    val email: String,

    @Field(name = "mobile")
    val mobile: String,

    @Field(name = "updatedAt")
    val updatedAt: LocalDateTime? = null,
) {

    @Field(name = "createdAt")
    val createdAt: LocalDateTime = LocalDateTime.now()

    companion object {
        fun fixture(
            name: String = "Test",
            email: String = "minxhvk@gmail.com",
            mobile: String = "010-0000-0000",
            password: String = "asd1234!",
            id: String? = null
        ): User {
            return User(
                name = name,
                email = email,
                mobile = mobile,
                password = password,
                id = id,
            )
        }
    }

}