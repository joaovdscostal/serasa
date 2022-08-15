package serasa.com.br.desafio.presentation.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
public class ScoreRequestModel {

	@Schema(required = true, example = "scoreDescricao", description = "Descricao do score")
	@NotEmpty(message = "O Campo scoreDescricao é obrigatorio")
	private String scoreDescricao;

	@Schema(required = true, example = "0", description = "Score inicial")
	@NotNull(message = "O Campo scoreInicial é obrigatorio")
	private Integer scoreInicial;

	@Schema(required = true, example = "12", description = "Score final")
	@NotNull(message = "O Campo scoreFinal é obrigatorio")
	private Integer scoreFinal;

}

