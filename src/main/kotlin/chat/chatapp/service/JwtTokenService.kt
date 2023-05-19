package chat.chatapp.service

import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtParser
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.*

@Service
class JwtTokenService {

    @Value("\${spring.jwt.secret}")
    private lateinit var SECRET_KEY: String
    private lateinit var signingKey: Key
    private lateinit var jwtParser: JwtParser
    
    private val KEY_USER_ID: String = "user_id"
    private val tokenValidTime = 30 * 60 * 1000L

    @PostConstruct
    fun init() {
        SECRET_KEY = Base64.getEncoder().encodeToString(SECRET_KEY.toByteArray())
        signingKey = Keys.hmacShaKeyFor(SECRET_KEY.toByteArray(StandardCharsets.UTF_8))
        jwtParser = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build()
    }

    fun isValidToken(token: String): Boolean {
        return jwtParser.isSigned(token)
    }

    // 토큰에서 회원 정보 추출
    fun getUserId(token: String): String {
        return Jwts.parserBuilder()
            .setSigningKey(signingKey).build()
            .parseClaimsJws(token).body.subject
    }


    fun generateToken(userDetails: UserDetails): String {
        val claims: Claims = Jwts.claims() // JWT payload 에 저장되는 정보단위
        claims[KEY_USER_ID] = userDetails.username

        return createToken(claims)
    }

    private fun createToken(claims: Claims): String {

        val now = Date()

        return Jwts.builder()
            .setClaims(claims) // 정보 저장
            .setIssuedAt(now) // 토큰 발행 시간 정보
            .setExpiration(Date(now.time + tokenValidTime)) // set Expire Time
            .signWith(signingKey, SignatureAlgorithm.HS256).compact() // 사용할 암호화 알고리즘과 signature 에 들어갈 secret값 세팅
    }
}
