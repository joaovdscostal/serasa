package serasa.com.br.desafio.infra.dataprovider.gateway;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import serasa.com.br.desafio.core.dto.ScoreDTO;
import serasa.com.br.desafio.core.gateway.ScoreGateway;
import serasa.com.br.desafio.core.mapper.ScoreModelMap;
import serasa.com.br.desafio.infra.config.exception.EntityNotFoundException;
import serasa.com.br.desafio.infra.dataprovider.database.entity.Score;
import serasa.com.br.desafio.infra.dataprovider.database.repository.ScoreRepository;

@Component
@RequiredArgsConstructor
public class ScoreGatewayImpl implements ScoreGateway {

	private final ScoreRepository scoreRepository;
	private final ScoreModelMap scoreModelMap;

	@Override
	public void adicionaScore(ScoreDTO scoreDTO) {
		Score score = scoreModelMap.DTOToEntity(scoreDTO);
		scoreRepository.save(score);
	}

	@Override
	public String buscaScoreDescricaoPorValorDoScore(Integer value) {
		Score score = scoreRepository.findByScoreConsult(value).orElseThrow(() ->  new EntityNotFoundException("Nao existe  score cadastrado para o valor " + value));
		return score.getScoreDescricao();
	}

}
