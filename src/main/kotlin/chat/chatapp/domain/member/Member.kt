package chat.chatapp.domain.member

import chat.chatapp.domain.BaseTime
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.validation.constraints.Email


@Document(collection = "member")
class Member constructor(

    @Id
    val id: String? = null,

    @Field("name")
    var name: String,

    @Email
    val email: String,

    @Field(name = "mobile")
    val mobile: String,

    @Field(name = "password")
    private var password: String,

    ): BaseTime(), UserDetails {


    // TODO
    init {
        require(name.length < 40) {
            throw IllegalArgumentException("이름은 40자 이내로 입력해야 합니다.")
        }

        require(email.length < 40) {
            throw IllegalArgumentException("이메일은 40자 이내로 입력해야 합니다.")
        }

        // Mobile Format

        check(name.isNotBlank()) {
            throw IllegalArgumentException("이름은 비어있을 수 없습니다.")
        }

        check(email.isNotBlank()) {
            throw IllegalArgumentException("이메일은 비어있을 수 없습니다.")
        }

    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return null
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun withId(id: String?): Member = Member(id, name, email, mobile, password)


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