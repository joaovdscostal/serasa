package serasa.com.br.desafio.presentation.entrypoint.pessoa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import serasa.com.br.desafio.core.dto.PessoaScoreDTO;
import serasa.com.br.desafio.core.mapper.PessoaModelMap;
import serasa.com.br.desafio.core.usecase.pessoa.AdicionaPessoaBoundary;
import serasa.com.br.desafio.core.usecase.pessoa.BuscaPessoaPorIdBoundary;
import serasa.com.br.desafio.core.usecase.pessoa.BuscaTodasPessoasBoundary;
import serasa.com.br.desafio.presentation.model.request.PessoaRequestModel;
import serasa.com.br.desafio.presentation.model.response.PessoaCidadeResponseModel;
import serasa.com.br.desafio.presentation.model.response.PessoaTelefoneResponseModel;

@Validated
@RestController
@RequestMapping
@AllArgsConstructor
public class PessoaController implements PessoaDocument {

	private final PessoaModelMap pessoaModelMap;

	private final AdicionaPessoaBoundary adicionaPessoaBoundary;
	private final BuscaPessoaPorIdBoundary buscaPessoaBoundary;
	private final BuscaTodasPessoasBoundary buscaTodasPessoasBoundary;

	@PostMapping("/pessoa")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void adicionaPessoa(@RequestBody PessoaRequestModel pessoaRequest) {
		this.adicionaPessoaBoundary.execute(pessoaModelMap.requestModelToDto(pessoaRequest));
	}

	@GetMapping(value = "/pessoa/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public PessoaTelefoneResponseModel buscaPorId(@PathVariable(value = "id", required = true) Long idPessoa) {
		PessoaScoreDTO pessoaTelefoneDTO = buscaPessoaBoundary.execute(idPessoa);
		return pessoaModelMap.pessoaScoreDTOToPessoaTelefoneResponseModel(pessoaTelefoneDTO);
	}

	@GetMapping(value = "/pessoa")
	@ResponseStatus(code = HttpStatus.OK)
	public List<PessoaCidadeResponseModel> buscaTodasAsPessoas() {
		return buscaTodasPessoasBoundary.execute()
				.stream()
				.map(pessoaModelMap::pessoaScoreDTOToPessoaCidadeResponseModel)
				.collect(Collectors.toList());
	}
}