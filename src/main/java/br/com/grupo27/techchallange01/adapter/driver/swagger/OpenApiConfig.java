package br.com.grupo27.techchallange01.adapter.driver.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Tech-Challenge")
                                 .description("Desafio desenvolvido para a pós em Software Architeture da FIAP")
                                 .version("1.0"));
    }
}