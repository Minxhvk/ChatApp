package chat.chatapp.domain.user

import chat.chatapp.domain.PrimaryKeyEntity
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import javax.validation.constraints.Email


@Document(collection = "users")
class User(
    name: String,
    email: String,
    password: String,
    mobile: String,
): PrimaryKeyEntity() {

    @Field("name")
    var name: String = name
        private set

    @Email
    var email: String = email
        private set

    @Field(name = "password")
    var password: String = password
        private set

    @Field(name = "mobile")
    var mobile: String = mobile
        private set

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
            )
        }
    }

}