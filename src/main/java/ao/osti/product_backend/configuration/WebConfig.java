package ao.osti.product_backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Aplicar CORS para todos os endpoints
                        .allowedOrigins("http://localhost:4200") // Permitir a origem do frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                        .allowedHeaders("*") // Cabeçalhos permitidos
                        .allowCredentials(true); // Permitir credenciais (cookies/autenticação)
            }
        };
    }
}
