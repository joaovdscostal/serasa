package serasa.com.br.desafio.core.mapper;

import java.util.List;

import serasa.com.br.desafio.core.dto.PessoaDTO;
import serasa.com.br.desafio.core.dto.PessoaScoreDTO;

public class PessoaScoreMapper {

	public static PessoaScoreDTO montarPessoaScoreAfinidade(PessoaDTO pessoa, List<String> estados, String scoreDescricao) {
		return PessoaScoreDTO.builder()
									  .nome(pessoa.getNome())
									  .telefone(pessoa.getTelefone())
									  .idade(pessoa.getIdade())
									  .cidade(pessoa.getCidade())
									  .estado(pessoa.getEstado())
									  .scoreDescricao(scoreDescricao)
									  .estados(estados)
									  .build();
	}

}
