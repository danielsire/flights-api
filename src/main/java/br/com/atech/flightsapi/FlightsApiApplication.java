package br.com.atech.flightsapi;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.google.common.base.Predicates;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import({ SpringDataRestConfiguration.class })
public class FlightsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsApiApplication.class, args);
	}
	
	@Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
				.apis(
						Predicates
						.not(RequestHandlerSelectors
								.basePackage("org.springframework.boot"))).build()
        		.apiInfo(getApiInfo());
    }
    
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Flights API",
                "API to list the flights",
                "v1.0.0",
                null,
                null,
                null,
                null,
                Collections.emptyList()
        );
    }

}
