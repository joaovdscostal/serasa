package serasa.com.br.desafio.presentation.model.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreRequestModelTest {

	private static String scoreDescricao = "Insuficiente";
	private static Integer scoreInicial = 0;
	private static Integer scoreFinal = 200;
	private static ScoreRequestModel model = new ScoreRequestModel(scoreDescricao, scoreInicial, scoreFinal);

	@Test
	void descricao() {
		Assertions.assertEquals(scoreDescricao, model.getScoreDescricao(), "O atributo experado nao é igual");
	}
	@Test
	void scoreInicial() {
		Assertions.assertEquals(scoreInicial, model.getScoreInicial(), "O atributo experado nao é igual");
	}
	@Test
	void scoreFinal() {
		Assertions.assertEquals(scoreFinal, model.getScoreFinal(), "O atributo experado nao é igual");
	}

}
