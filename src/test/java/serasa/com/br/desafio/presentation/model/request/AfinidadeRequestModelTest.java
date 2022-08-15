package serasa.com.br.desafio.presentation.model.request;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AfinidadeRequestModelTest {

	private static final String regiao = "sudeste";
	private static final List<String> estados = Arrays.asList("RJ", "SP");
	private static final AfinidadeRequestModel model = new AfinidadeRequestModel(regiao, estados);

	@Test
	void testGetRegiao() {
		Assertions.assertEquals(regiao, model.getRegiao(), "O atributo experado nao é igual");
	}

	@Test
	void testGetEstados() {
		Assertions.assertEquals(estados, model.getEstados(), "O atributo experado nao é igual");
	}

}
