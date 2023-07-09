package br.com.grupo27.techchallange01.config;

import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class EnvConfig {
    public void configEnviroments() {
        Dotenv dotenv = Dotenv.load();
        String db = dotenv.get("POSTGRES_DB");
        String user = dotenv.get("POSTGRES_USER");
        String password = dotenv.get("POSTGRES_PASSWORD");
                

    }
}
