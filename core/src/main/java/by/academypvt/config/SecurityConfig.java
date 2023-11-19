package by.academypvt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoderByCrypt() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).httpBasic(Customizer.withDefaults()).authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/user/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/user/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/order/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/order/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/order/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/registration/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/pizza/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/pizza/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/pizza/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/pizza/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/sauce/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/sauce/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/sauce/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/ingredient/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/ingredient/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/ingredient/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/admin/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/admin/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/admin/**").hasAuthority("ADMIN"))
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer.logoutUrl("/logout")
                        .invalidateHttpSession(true).deleteCookies("JSESSIONID"));
        return http.build();
    }
}