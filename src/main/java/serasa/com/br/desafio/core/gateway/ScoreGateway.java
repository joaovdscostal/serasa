package serasa.com.br.desafio.core.gateway;

import serasa.com.br.desafio.core.dto.ScoreDTO;

public interface ScoreGateway {
	void adicionaScore(ScoreDTO scoreDTO);
	String buscaScoreDescricaoPorValorDoScore(Integer score);
}
