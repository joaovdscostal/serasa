package serasa.com.br.desafio.core.usecase.afinidade;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import serasa.com.br.desafio.core.dto.AfinidadeDTO;
import serasa.com.br.desafio.core.gateway.AfinidadeGateway;

@Service
@RequiredArgsConstructor
public class AdicionaAfinidadeInteractor implements AdicionaAfinidadeBoundary{

	private final AfinidadeGateway afinidadeGateway;

	@Override
	public void execute(AfinidadeDTO afinidadeDTO) {
		afinidadeGateway.adicionaAfinidade(afinidadeDTO);
	}

}
