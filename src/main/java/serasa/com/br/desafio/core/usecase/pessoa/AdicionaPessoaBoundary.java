package serasa.com.br.desafio.core.usecase.pessoa;

import serasa.com.br.desafio.core.dto.PessoaDTO;

public interface AdicionaPessoaBoundary {

	void execute(PessoaDTO pessoaDTO);

}
