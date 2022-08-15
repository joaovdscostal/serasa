package serasa.com.br.desafio.core.dto;

import lombok.Data;

@Data
public class PessoaDTO {
	private String nome;
	private String telefone;
	private Integer idade;
	private String cidade;
	private String estado;
	private String regiao;
	private Integer score;
}
