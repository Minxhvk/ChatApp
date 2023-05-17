package chat.chatapp.domain.user

import com.querydsl.core.annotations.QueryEntity
import jakarta.persistence.Entity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.Size


@Document(collection = "users")
class User(

    @Id
    @Field("_id")
    var id: String? = null,

    val name: String,

    @Email
    val email: String,

    @Field(name = "password")
    val password: String,

    @Field(name = "mobile")
    val mobile: String,

    @Field(name = "updated_at")
    val updatedAt: LocalDateTime? = null,

    @Field(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    init {
        require(name.length < 40) {
            throw IllegalArgumentException("이름은 40자 이내로 입력해야 합니다.")
        }

        require(email.length < 40) {
            throw IllegalArgumentException("이메일은 40자 이내로 입력해야 합니다.")
        }

        // TODO Mobile Format

        check(name.isNotBlank()) {
            throw IllegalArgumentException("이름은 비어있을 수 없습니다.")
        }

        check(email.isNotBlank()) {
            throw IllegalArgumentException("이메일은 비어있을 수 없습니다.")
        }

    }

    companion object {
        fun fixture(
            name: String = "Test",
            email: String = "minxhvk@gmail.com",
            mobile: String = "010-0000-0000",
            password: String = "asd1234!",
        ): User {
            return User(
                name = name,
                email = email,
                mobile = mobile,
                password = password,
                id = null,
            )
        }
    }

}