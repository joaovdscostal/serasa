package serasa.com.br.desafio.presentation.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
public class PessoaRequestModel {

	@Schema(required = true, example = "João Victor da Silveira Costa", description = "Nome da pessoa")
	@NotEmpty(message = "O Campo nome é obrigatorio")
	private String nome;

	@Schema(required = true, example = "22999604234", description = "Telefone")
	@NotEmpty(message = "O Campo telefone é obrigatorio")
	private String telefone;

	@Schema(required = true, example = "12", description = "Idade")
	@NotNull(message = "O Campo idade é obrigatorio")
	private Integer idade;

	@Schema(required = true, example = "Itaperuna", description = "Cidade")
	@NotEmpty(message = "O Campo cidade é obrigatorio")
	private String cidade;

	@Schema(required = true, example = "RJ", description = "Estado", allowableValues = {"AC", "AL", "AM", "AP", "BA", "CE",
			"DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
			"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"})
	@NotEmpty(message = "O Campo estado é obrigatorio")
	private String estado;

	@Schema(required = true, example = "sudeste", description = "Regiao.")
	@NotEmpty(message = "O Campo regiao é obrigatorio")
	private String regiao;

	@Schema(required = true, example = "12", description = "Score")
	@NotNull(message = "O Campo score é obrigatorio")
	private Integer score;

}

