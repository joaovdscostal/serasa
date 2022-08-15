package serasa.com.br.desafio.presentation.model.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
public class AfinidadeRequestModel {

	@Schema(required = true, example = "sudeste", description = "Regiao")
	@NotEmpty(message = "O Campo regiao é obrigatorio")
	private String regiao;

	@Schema(required = true, example = "[\"RJ\",\"SP\"]", description = "Estados")
	@NotEmpty(message = "O Campo estados é obrigatorio")
	private List<String> estados;

}

