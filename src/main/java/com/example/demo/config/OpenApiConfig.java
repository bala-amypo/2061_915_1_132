import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
    servers = {
        @Server(url = "https://9270.pro604cr.amypo.ai/", description = "Production Server"),
        @Server(url = "http://localhost:8080", description = "Local Development Server")
    }
)
@SpringBootApplication
public class SkillBarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkillBarterApplication.class, args);
    }
}