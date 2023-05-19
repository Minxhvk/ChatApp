package chat.chatapp.controller.member

import chat.chatapp.dto.request.member.MemberCreateRequest
import chat.chatapp.service.user.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class MemberController(
    private val memberService: MemberService
) {

    @PostMapping("/")
    fun saveMember(@RequestBody request: MemberCreateRequest) {
        memberService.saveUser(request)
    }
}