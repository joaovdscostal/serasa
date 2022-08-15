package serasa.com.br.desafio.core.usecase.score;

import serasa.com.br.desafio.core.dto.ScoreDTO;

public interface AdicionaScoreBoundary {

	void execute(ScoreDTO scoreDTO);

}
