package serasa.com.br.desafio.infra.config.documentation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

	@Value("${app.version}")
	private String appVersion;

	@Value("${app.description}")
	private String appDescription;

	@Bean
	public OpenAPI criaOpenAPI() {
		return new OpenAPI()
						.info(getInfo())
						.components(new Components());
	}

	private Info getInfo() {
		return new Info()
					.title("Desafio Serasa Experian")
					.description(appDescription)
					.version(appVersion)
					.contact(new Contact().name("João Victor da Silveira Costa").email("joaovdscostal@gmail.com"));
	}

}
