package serasa.com.br.desafio.core.usecase.pessoa;

import java.util.List;

import serasa.com.br.desafio.core.dto.PessoaScoreDTO;

public interface BuscaTodasPessoasBoundary {

	List<PessoaScoreDTO> execute();

}
