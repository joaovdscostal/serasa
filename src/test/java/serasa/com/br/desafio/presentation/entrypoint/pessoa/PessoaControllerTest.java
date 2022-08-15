package serasa.com.br.desafio.presentation.entrypoint.pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.openMocks;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;

import serasa.com.br.desafio.core.dto.PessoaScoreDTO;
import serasa.com.br.desafio.core.mapper.PessoaModelMap;
import serasa.com.br.desafio.core.usecase.pessoa.AdicionaPessoaBoundary;
import serasa.com.br.desafio.core.usecase.pessoa.BuscaPessoaPorIdBoundary;
import serasa.com.br.desafio.core.usecase.pessoa.BuscaTodasPessoasBoundary;
import serasa.com.br.desafio.presentation.model.request.PessoaRequestModel;
import serasa.com.br.desafio.presentation.model.response.PessoaTelefoneResponseModel;
import serasa.com.br.desafio.util.MockUtils;

class PessoaControllerTest {

	@Mock private AdicionaPessoaBoundary adicionaPessoaBoundary;
	@Mock private BuscaPessoaPorIdBoundary buscaPessoaBoundary;
	@Mock private BuscaTodasPessoasBoundary buscaTodasPessoasBoundary;

	private PessoaModelMap pessoaModelMap = Mappers.getMapper(PessoaModelMap.class);

	private PessoaController pessoaController;

	@BeforeEach
	void setUp() throws Exception {
		openMocks(this);
		pessoaController = new PessoaController(pessoaModelMap, adicionaPessoaBoundary, buscaPessoaBoundary, buscaTodasPessoasBoundary);
	}


	@Test
	void testAdicionaPessoa() {
		 doNothing().when(this.adicionaPessoaBoundary).execute(any());
		 PessoaRequestModel request = MockUtils.readMockedJSON("pessoa-request-model.json", PessoaRequestModel.class);
		 this.pessoaController.adicionaPessoa(request);
	}

	@Test
	void testBuscaPorId() {
		doReturn(MockUtils.readMockedJSON("pessoa-score-dto.json", PessoaScoreDTO.class)).when(this.buscaPessoaBoundary).execute(any());
		PessoaTelefoneResponseModel response = this.pessoaController.buscaPorId(1l);
		assertNotNull(response);
		assertEquals(response.getNome(), "Joao");
	}

	@Test
	void testBuscaTodasAsPessoas() {
		doReturn(List.of(MockUtils.readMockedJSON("pessoa-score-dto.json", PessoaScoreDTO.class))).when(this.buscaTodasPessoasBoundary).execute();
		assertNotNull(this.pessoaController.buscaTodasAsPessoas());
	}

}
