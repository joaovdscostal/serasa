package serasa.com.br.desafio.presentation.model.response;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PessoaCidadeResponseModel {

	@Schema(required = true, example = "João Victor", description = "Nome")
	private String nome;

	@Schema(required = true, example = "Itaperuna", description = "Cidade")
	@NotEmpty(message = "O Campo cidade é obrigatorio")
	private String cidade;

	@Schema(required = true, example = "RJ", description = "Estado", allowableValues = {"AC", "AL", "AM", "AP", "BA", "CE",
			"DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
			"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"})
	@NotEmpty(message = "O Campo estado é obrigatorio")
	private String estado;

	@Schema(required = true, example = "Recomendavel", description = "Descricao do score")
	private String scoreDescricao;

	@Schema(required = true, example = "[\"RJ\",\"SP\"]", description = "Estados")
	private List<String> estados;
}
