package serasa.com.br.desafio.presentation.entrypoint.score;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import serasa.com.br.desafio.core.mapper.ScoreModelMap;
import serasa.com.br.desafio.core.usecase.score.AdicionaScoreBoundary;
import serasa.com.br.desafio.presentation.model.request.ScoreRequestModel;
import serasa.com.br.desafio.util.MockUtils;

class ScoreControllerTest {

	@Mock private AdicionaScoreBoundary adicionaScoreBoundary;
	@Mock private ScoreModelMap scoreModelMap;

	private ScoreController scoreController;

	@BeforeEach
	void setUp() throws Exception {
		openMocks(this);
		scoreController = new ScoreController(scoreModelMap, adicionaScoreBoundary);
	}

	@Test
	void testAdicionaScore() {
		 doNothing().when(this.adicionaScoreBoundary).execute(any());
		 ScoreRequestModel request = MockUtils.readMockedJSON("score-request-model.json", ScoreRequestModel.class);
		 this.scoreController.adicionaScore(request);
	}

}
