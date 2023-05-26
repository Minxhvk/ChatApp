package chat.chatapp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class WebAuthenticationConfiguration {

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity ->
            web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**")
        }
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .csrf()
            .disable()

        http
            .authorizeHttpRequests()
            .requestMatchers("/api/v1/user/signup").permitAll()
//            .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
//            .requestMatchers("/admin/**").hasRole("ADMIN")
//            .anyRequest()
            .anyRequest().authenticated()
            .and().formLogin()
            .loginPage("/login")
                .usernameParameter("email")
                .permitAll()

        http.headers().frameOptions().sameOrigin()

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}