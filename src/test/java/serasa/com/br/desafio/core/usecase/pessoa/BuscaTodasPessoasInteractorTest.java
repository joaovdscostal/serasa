package serasa.com.br.desafio.core.usecase.pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import serasa.com.br.desafio.core.dto.PessoaDTO;
import serasa.com.br.desafio.core.dto.PessoaScoreDTO;
import serasa.com.br.desafio.core.gateway.AfinidadeGateway;
import serasa.com.br.desafio.core.gateway.PessoaGateway;
import serasa.com.br.desafio.core.gateway.ScoreGateway;
import serasa.com.br.desafio.util.MockUtils;

class BuscaTodasPessoasInteractorTest {

	@Mock private PessoaGateway pessoaGateway;
	@Mock private AfinidadeGateway afinidadeGateway;
	@Mock private ScoreGateway scoreGateway;

	private BuscaTodasPessoasBoundary boundary;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		doReturn(List.of(MockUtils.readMockedJSON("pessoa-dto.json", PessoaDTO.class))).when(pessoaGateway).buscaTodasPessoas();
		doReturn(Arrays.asList("RJ", "SP")).when(afinidadeGateway).buscaEstadosPorRegiao("sudesde");
		doReturn("Inaceitável").when(scoreGateway).buscaScoreDescricaoPorValorDoScore(300);

		boundary = new BuscaTodasPessoasInteractor(pessoaGateway, afinidadeGateway, scoreGateway);
	}

	@Test
	void testExecute() {
		List<PessoaScoreDTO> pessoas = boundary.execute();

		assertNotNull(pessoas);
		assertEquals(pessoas.get(0).getNome(), "Joao");
		assertEquals(pessoas.get(0).getScoreDescricao(), "Inaceitável");
	}

	@Test
	void testExecuteNaoEncontrouPessoas() {
		when(pessoaGateway.buscaTodasPessoas()).thenThrow(EntityNotFoundException.class);
		Assertions.assertThrows(EntityNotFoundException.class, () -> boundary.execute());
	}

}
