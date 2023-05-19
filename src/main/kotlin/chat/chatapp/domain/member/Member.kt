package chat.chatapp.domain.member

import chat.chatapp.domain.PrimaryKeyEntity
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import javax.validation.constraints.Email


@Document(collection = "member")
class Member constructor(
    @Field("name")
    var name: String,

    @Email
    var email: String,

    @Field(name = "mobile")
    var mobile: String,

    @Field(name = "password")
    var password: String,

): PrimaryKeyEntity() {

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
        ): Member {
            return Member(
                name = name,
                email = email,
                mobile = mobile,
                password = password,
            )
        }
    }

}