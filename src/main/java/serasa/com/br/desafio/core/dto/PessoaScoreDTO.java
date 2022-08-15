package serasa.com.br.desafio.core.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaScoreDTO {
	private String nome;
	private String telefone;
	private String cidade;
	private String estado;
	private Integer idade;
	private String scoreDescricao;
	private List<String> estados;
}
