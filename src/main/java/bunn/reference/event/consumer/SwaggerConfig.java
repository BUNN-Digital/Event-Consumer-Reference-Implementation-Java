package bunn.reference.event.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI eventConsumerOpenAPI() {
		return new OpenAPI().info(apiInfo());
	}

	private Info apiInfo() {
		return new Info() //
				.title("BUNN® Customer Event Consumer Example API") //
				.description("BUNN® Customer Event Consumer Example API") //
				.version("0.1.0") //
				.termsOfService("https://www.bunn.com/terms-of-use");
	}

}
