package serasa.com.br.desafio.core.usecase.afinidade;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import serasa.com.br.desafio.core.dto.AfinidadeDTO;
import serasa.com.br.desafio.core.gateway.AfinidadeGateway;
import serasa.com.br.desafio.util.MockUtils;

class AdicionaAfinidadeInteractorTest {

	@Mock private AfinidadeGateway afinidadeGateway;
	private AdicionaAfinidadeBoundary boundary;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		doNothing().when(afinidadeGateway).adicionaAfinidade(any());

		boundary = new AdicionaAfinidadeInteractor(afinidadeGateway);
	}

	@Test
	void testExecute() {
		AfinidadeDTO dto = MockUtils.readMockedJSON("afinidade-dto.json", AfinidadeDTO.class);
		boundary.execute(dto);
	}
}
