package online.swiftlift.swiftlift.config

import online.swiftlift.swiftlift.service.SwiftLiftUserDetailsService
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val swiftLiftUserDetailsService: SwiftLiftUserDetailsService,
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
            .requestMatchers("/exercises/add", "/exercises/all", "/exercises/**").permitAll()
            .requestMatchers("/users/all").permitAll()
            .anyRequest().authenticated()
        }.formLogin {
            formLogin -> formLogin
            .loginPage("/users/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/")
            .failureForwardUrl("/users/login-error")
        }.logout {
            logout -> logout
            .logoutUrl("/users/logout")
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
        }.rememberMe {
            rememberMe -> rememberMe
            .key(rememberMeKey)
            .rememberMeParameter("remember-me")
            .rememberMeCookieName("remember-me")
//        }.oauth2Login {
//            it
//                .loginPage("/users/oauth2/login")
//                .defaultSuccessUrl("/")
//                .permitAll()
        }.build()

    @Bean
    fun passwordEncoder(): PasswordEncoder =
        Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8()

//    @Bean
    fun configureGlobal(auth: AuthenticationManagerBuilder): Unit {
        auth
            .userDetailsService(swiftLiftUserDetailsService)
            .passwordEncoder(passwordEncoder())
    }
}