package serasa.com.br.desafio.presentation.entrypoint.afinidade;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import serasa.com.br.desafio.core.mapper.AfinidadeModelMap;
import serasa.com.br.desafio.core.usecase.afinidade.AdicionaAfinidadeBoundary;
import serasa.com.br.desafio.presentation.model.request.AfinidadeRequestModel;

@Validated
@RestController
@RequestMapping
@AllArgsConstructor
public class AfinidadeController implements AfinidadeDocument {

	private final AfinidadeModelMap afinidadeModelMap;
	private final AdicionaAfinidadeBoundary adicionaAfinidadeBoundary;

	@PostMapping("/afinidade")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void adicionaAfinidade(@RequestBody AfinidadeRequestModel afinidadeRequest) {
		this.adicionaAfinidadeBoundary.execute(afinidadeModelMap.requestModelToDto(afinidadeRequest));
	}
}