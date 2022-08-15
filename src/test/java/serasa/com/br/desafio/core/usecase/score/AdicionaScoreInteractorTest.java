package serasa.com.br.desafio.core.usecase.score;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import serasa.com.br.desafio.core.dto.ScoreDTO;
import serasa.com.br.desafio.core.gateway.ScoreGateway;
import serasa.com.br.desafio.util.MockUtils;

class AdicionaScoreInteractorTest {

	@Mock private ScoreGateway scoreGateway;
	private AdicionaScoreBoundary boundary;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		doNothing().when(scoreGateway).adicionaScore(any());

		boundary = new AdicionaScoreInteractor(scoreGateway);
	}

	@Test
	void testExecute() {
		ScoreDTO dto = MockUtils.readMockedJSON("score-dto.json", ScoreDTO.class);
		boundary.execute(dto);
	}

}
