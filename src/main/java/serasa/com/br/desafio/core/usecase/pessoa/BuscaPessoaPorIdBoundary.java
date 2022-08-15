package serasa.com.br.desafio.core.usecase.pessoa;

import serasa.com.br.desafio.core.dto.PessoaScoreDTO;

public interface BuscaPessoaPorIdBoundary {

	PessoaScoreDTO execute(Long id);

}
