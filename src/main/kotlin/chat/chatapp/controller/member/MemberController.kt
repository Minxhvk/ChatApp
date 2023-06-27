package chat.chatapp.controller.member

import chat.chatapp.dto.member.MemberDto
import chat.chatapp.dto.request.sign.UserLoginRequest
import chat.chatapp.dto.request.sign.UserSignUpRequest
import chat.chatapp.service.member.MemberService
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
class MemberController(
    private val memberService: MemberService
) {

    @PostMapping("/signup")
    @ResponseStatus(code = HttpStatus.CREATED)
    fun signUp(@RequestBody request: UserSignUpRequest, response: HttpServletResponse): MemberDto {
        val memberDto = memberService.createUser(request)

        response.addCookie(Cookie("Authorization", memberDto.token))

        return memberDto
    }

    @PostMapping("/login")
    fun login(@RequestBody request: UserLoginRequest, response: HttpServletResponse): String {
        val memberDto = memberService.login(request)

        return "memberDto"
    }
}