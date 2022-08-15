package serasa.com.br.desafio.core.usecase.pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;

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

class BuscaPessoaPorIdInteractorTest {

	@Mock private PessoaGateway pessoaGateway;
	@Mock private AfinidadeGateway afinidadeGateway;
	@Mock private ScoreGateway scoreGateway;

	private BuscaPessoaPorIdBoundary boundary;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		doReturn(MockUtils.readMockedJSON("pessoa-dto.json", PessoaDTO.class)).when(pessoaGateway).buscaPorId(1L);
		doReturn(Arrays.asList("RJ", "SP")).when(afinidadeGateway).buscaEstadosPorRegiao("sudesde");
		doReturn("Inaceitável").when(scoreGateway).buscaScoreDescricaoPorValorDoScore(300);

		boundary = new BuscaPessoaPorIdInteractor(pessoaGateway, afinidadeGateway, scoreGateway);
	}

	@Test
	void testExecute() {
		PessoaScoreDTO scoreDTO = boundary.execute(1L);
		assertNotNull(scoreDTO);
		assertEquals(scoreDTO.getNome(), "Joao");
		assertEquals(scoreDTO.getTelefone(), "22999604234");
		assertEquals(scoreDTO.getCidade(), "Itaperuna");
		assertEquals(scoreDTO.getEstado(), "RJ");
		assertEquals(scoreDTO.getIdade(), 33);
		assertEquals(scoreDTO.getScoreDescricao(), "Inaceitável");
	}

	@Test
	void testExecuteNaoEncontrouPessoa() {
		when(pessoaGateway.buscaPorId(2L)).thenThrow(EntityNotFoundException.class);
		Assertions.assertThrows(EntityNotFoundException.class, () -> boundary.execute(2L));
	}

}
