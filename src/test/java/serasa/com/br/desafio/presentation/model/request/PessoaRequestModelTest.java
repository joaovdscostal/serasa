package serasa.com.br.desafio.presentation.model.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PessoaRequestModelTest {

    private static String nome = "Joao";
    private static String telefone = "22999604234";
	private static Integer idade = 33;
    private static String cidade = "Itaperuna";
    private static String estado = "RJ";
    private static String regiao = "sudeste";
    private static Integer score = 385;

    private static PessoaRequestModel model = new PessoaRequestModel(nome, telefone, idade, cidade, estado, regiao, score);

	@Test
	void testGetNome() {
		Assertions.assertEquals(nome, model.getNome(), "O atributo experado nao é igual");
	}

	@Test
	void testGetTelefone() {
		Assertions.assertEquals(telefone, model.getTelefone(), "O atributo experado nao é igual");
	}

	@Test
	void testGetIdade() {
		Assertions.assertEquals(idade, model.getIdade(), "O atributo experado nao é igual");
	}

	@Test
	void testGetCidade() {
		Assertions.assertEquals(cidade, model.getCidade(), "O atributo experado nao é igual");
	}

	@Test
	void testGetEstado() {
		Assertions.assertEquals(estado, model.getEstado(), "O atributo experado nao é igual");
	}

	@Test
	void testGetRegiao() {
		Assertions.assertEquals(regiao, model.getRegiao(), "O atributo experado nao é igual");
	}

	@Test
	void testGetScore() {
		Assertions.assertEquals(score, model.getScore(), "O atributo experado nao é igual");
	}

}
