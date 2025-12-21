import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// ... inside your @Configuration class ...

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}