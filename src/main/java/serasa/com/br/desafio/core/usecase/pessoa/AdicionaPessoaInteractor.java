package serasa.com.br.desafio.core.usecase.pessoa;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import serasa.com.br.desafio.core.dto.PessoaDTO;
import serasa.com.br.desafio.core.gateway.PessoaGateway;

@Service
@RequiredArgsConstructor
public class AdicionaPessoaInteractor implements AdicionaPessoaBoundary{

	private final PessoaGateway pessoaGateway;

	@Override
	public void execute(PessoaDTO pessoaDTO) {
		pessoaGateway.adicionaPessoa(pessoaDTO);
	}

}
