package serasa.com.br.desafio.core.gateway;

import java.util.List;

import serasa.com.br.desafio.core.dto.PessoaDTO;

public interface PessoaGateway {
	void adicionaPessoa(PessoaDTO pessoaDTO);
	PessoaDTO buscaPorId(Long id);
	List<PessoaDTO> buscaTodasPessoas();
}
