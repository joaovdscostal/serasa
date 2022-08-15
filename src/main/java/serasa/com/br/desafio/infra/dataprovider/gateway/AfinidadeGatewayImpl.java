package serasa.com.br.desafio.infra.dataprovider.gateway;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import serasa.com.br.desafio.core.dto.AfinidadeDTO;
import serasa.com.br.desafio.core.gateway.AfinidadeGateway;
import serasa.com.br.desafio.core.mapper.AfinidadeModelMap;
import serasa.com.br.desafio.infra.config.exception.EntityNotFoundException;
import serasa.com.br.desafio.infra.dataprovider.database.entity.Afinidade;
import serasa.com.br.desafio.infra.dataprovider.database.repository.AfinidadeRepository;

@Component
@RequiredArgsConstructor
public class AfinidadeGatewayImpl implements AfinidadeGateway {

	private final AfinidadeRepository afinidadeRepository;
	private final AfinidadeModelMap afinidadeModelMap;

	@Override
	public void adicionaAfinidade(AfinidadeDTO afinidadeDTO) {
		Afinidade afinidade = afinidadeModelMap.DTOToEntity(afinidadeDTO);
		afinidadeRepository.save(afinidade);
	}

	@Override
	public List<String> buscaEstadosPorRegiao(String regiao) {
		Afinidade afinidade = afinidadeRepository.findByRegiao(regiao).orElseThrow(() ->  new EntityNotFoundException("Nao existe afinidade encontrada para regiao " + regiao));
		return afinidade.getEstados();
	}

}
