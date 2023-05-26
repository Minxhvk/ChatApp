package chat.chatapp.controller.member

import chat.chatapp.dto.member.MemberDto
import chat.chatapp.dto.request.sign.LoginRequest
import chat.chatapp.dto.request.sign.SignUpRequest
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
    fun signUp(@RequestBody request: SignUpRequest, response: HttpServletResponse): MemberDto {
        val memberDto = memberService.saveUser(request)

        response.addCookie(Cookie("Authorization", memberDto.token))

        return memberDto
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest, response: HttpServletResponse): String {
        val memberDto = memberService.login(request)

        return "memberDto"
    }
}