package serasa.com.br.desafio.presentation.entrypoint.afinidade;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import serasa.com.br.desafio.core.mapper.AfinidadeModelMap;
import serasa.com.br.desafio.core.usecase.afinidade.AdicionaAfinidadeBoundary;
import serasa.com.br.desafio.presentation.model.request.AfinidadeRequestModel;
import serasa.com.br.desafio.util.MockUtils;

class AfinidadeControllerTest {

	@Mock private AdicionaAfinidadeBoundary adicionaAfinidadeBoundary;
	@Mock private AfinidadeModelMap afinidadeModelMap;

	private AfinidadeController afinidadeController;

	@BeforeEach
	void setUp() throws Exception {
		openMocks(this);
		afinidadeController = new AfinidadeController(afinidadeModelMap, adicionaAfinidadeBoundary);
	}

	@Test
	void testAdicionaAfinidade() {
		 doNothing().when(this.adicionaAfinidadeBoundary).execute(any());
		 AfinidadeRequestModel request = MockUtils.readMockedJSON("afinidade-request-model.json", AfinidadeRequestModel.class);
		 this.afinidadeController.adicionaAfinidade(request);
	}

}
