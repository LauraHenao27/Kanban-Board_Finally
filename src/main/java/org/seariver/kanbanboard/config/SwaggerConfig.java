package org.seariver.kanbanboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration //para configurar componentes y configuraciones específicas
@EnableSwagger2 //habilita Swagger 2 en la aplicación Spring Boot.

//Documentemos esta joda!!!!

public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select() //Elementos a documentar
            .apis(basePackage("org.seariver.kanbanboard"))
            .build();
    }
}
