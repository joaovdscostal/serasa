package serasa.com.br.desafio.presentation.entrypoint.score;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import serasa.com.br.desafio.infra.config.exception.handler.ApiErrorResponse;
import serasa.com.br.desafio.presentation.model.request.ScoreRequestModel;

@Tag(name = "Score", description = "Serviço responsável pela manutenção de scores.")
@ApiResponses(
		value = {
                @ApiResponse(responseCode = "400", description = "Parâmetros incorretos (os dados de entradas estão incorretos ou ausentes).", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
                @ApiResponse(responseCode = "500", description = "Erro Inesperado. Se o problema persistir, entre em contato o Owner da Api.", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
                @ApiResponse(responseCode = "204", description = "Informacoes nao encontradas.")
        }
)
public interface ScoreDocument {

	@Operation(summary = "Inclusão de scores.")
	@ApiResponse(responseCode = "201", description = "Ok")
	void adicionaScore(@Valid ScoreRequestModel scoreRequest);

}