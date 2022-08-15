package serasa.com.br.desafio.presentation.model.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PessoaTelefoneResponseModel {

	@Schema(required = true, example = "João Victor", description = "Nome")
	private String nome;

	@Schema(required = true, example = "22999604234", description = "Telefone")
	private String telefone;

	@Schema(required = true, example = "12", description = "Idade")
	private Integer idade;

	@Schema(required = true, example = "Recomendavel", description = "Descricao do score")
	private String scoreDescricao;

	@Schema(required = true, example = "[\"RJ\",\"SP\"]", description = "Estados")
	private List<String> estados;
}
