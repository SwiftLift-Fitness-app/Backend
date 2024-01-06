package online.swiftlift.swiftlift.config

import online.swiftlift.swiftlift.model.enum.Role
import online.swiftlift.swiftlift.repository.UserRepository
import online.swiftlift.swiftlift.service.impl.SwiftLiftUserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    @Value("\${swiftlift.remember.me.key}") private val rememberMeKey: String
) {

    @Bean
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain =
        httpSecurity
            .csrf { it.disable() }
            .authorizeHttpRequests {
            authorizeRequests -> authorizeRequests
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            .requestMatchers("/").permitAll()
            .requestMatchers("/users/login", "/users/register", "/users/login-error").permitAll()
            .requestMatchers("/users/all").permitAll()
            .anyRequest().authenticated()
        }.formLogin {
            formLogin -> formLogin
            .loginPage("/users/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/")
            .failureForwardUrl("/users/login-error")
//        }.logout {
//            logout -> logout
//            .logoutUrl("/users/logout")
//            .logoutSuccessUrl("/")
//            .invalidateHttpSession(true)
        }.rememberMe {
            rememberMe -> rememberMe
            .key(rememberMeKey)
            .rememberMeParameter("remember-me")
            .rememberMeCookieName("remember-me")
        }.build()

//    @Bean
//    fun userDetailsService(userRepository: UserRepository): UserDetailsService =
//        SwiftLiftUserDetailsServiceImpl(userRepository)

    @Bean
    fun passwordEncoder(): PasswordEncoder =
        Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8()
}