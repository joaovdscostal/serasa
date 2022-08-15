package serasa.com.br.desafio.presentation.entrypoint.score;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import serasa.com.br.desafio.core.mapper.ScoreModelMap;
import serasa.com.br.desafio.core.usecase.score.AdicionaScoreBoundary;
import serasa.com.br.desafio.presentation.model.request.ScoreRequestModel;

@Validated
@RestController
@RequestMapping
@AllArgsConstructor
public class ScoreController implements ScoreDocument {

	private final ScoreModelMap scoreModelMap;
	private final AdicionaScoreBoundary adicionaScoreBoundary;

	@PostMapping("/score")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void adicionaScore(@RequestBody ScoreRequestModel scoreRequest) {
		this.adicionaScoreBoundary.execute(scoreModelMap.requestModelToDto(scoreRequest));
	}
}