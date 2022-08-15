package serasa.com.br.desafio.core.gateway;

import java.util.List;

import serasa.com.br.desafio.core.dto.AfinidadeDTO;

public interface AfinidadeGateway {
	void adicionaAfinidade(AfinidadeDTO afinidadeDTO);
	List<String> buscaEstadosPorRegiao(String regiao);

}
