package chat.chatapp.config

import chat.chatapp.security.handler.AuthFailuereHandler
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.core.AuthenticationException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler


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
            .csrf().disable()
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers("/api/v1/user/signup").permitAll()
                    .anyRequest().authenticated()
//                    .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
//                    .requestMatchers("/admin/**").hasRole("ADMIN")
//                    .anyRequest()
            }
            .formLogin { formLogin ->
                formLogin
                    .loginPage("/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .failureHandler(AuthFailuereHandler())
                    .permitAll()
            }
            .exceptionHandling { exceptionHandling ->
                exceptionHandling.authenticationEntryPoint(authenticationEntryPoint())
            }

        return http.build()
    }

//    @Bean
//    fun authenticationFailureHandler(): AuthenticationFailureHandler {
//        return AuthenticationFailureHandler { request, response, exception ->
//            response.writer.println(exception.message)
//            response.status = HttpServletResponse.SC_UNAUTHORIZED
//        }
//    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationEntryPoint(): AuthenticationEntryPoint {
        return AuthenticationEntryPoint { _, response, authException ->
            response.status = HttpServletResponse.SC_UNAUTHORIZED
            response.writer.println(authException?.message)
        }
    }
}