package serasa.com.br.desafio.core.usecase.pessoa;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import serasa.com.br.desafio.core.dto.PessoaDTO;
import serasa.com.br.desafio.core.gateway.PessoaGateway;
import serasa.com.br.desafio.util.MockUtils;

class AdicionaPessoaInteractorTest {

	@Mock private PessoaGateway pessoaGateway;
	private AdicionaPessoaBoundary boundary;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		doNothing().when(pessoaGateway).adicionaPessoa(any());

		boundary = new AdicionaPessoaInteractor(pessoaGateway);
	}

	@Test
	void testExecute() {
		PessoaDTO dto = MockUtils.readMockedJSON("pessoa-dto.json", PessoaDTO.class);
		boundary.execute(dto);
	}
}
