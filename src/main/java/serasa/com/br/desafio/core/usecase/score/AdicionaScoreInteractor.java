package serasa.com.br.desafio.core.usecase.score;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import serasa.com.br.desafio.core.dto.ScoreDTO;
import serasa.com.br.desafio.core.gateway.ScoreGateway;

@Service
@RequiredArgsConstructor
public class AdicionaScoreInteractor implements AdicionaScoreBoundary{

	private final ScoreGateway scoreGateway;

	@Override
	public void execute(ScoreDTO scoreDTO) {
		scoreGateway.adicionaScore(scoreDTO);
	}

}
