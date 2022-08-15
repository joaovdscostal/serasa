package serasa.com.br.desafio.presentation.entrypoint.afinidade;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import serasa.com.br.desafio.infra.config.exception.handler.ApiErrorResponse;
import serasa.com.br.desafio.presentation.model.request.AfinidadeRequestModel;

@Tag(name = "Afinidade", description = "Serviço responsável pela manutenção de afinidades.")
@ApiResponses(
        value = {
                @ApiResponse(responseCode = "400", description = "Parâmetros incorretos (os dados de entradas estão incorretos ou ausentes).", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
                @ApiResponse(responseCode = "500", description = "Erro Inesperado. Se o problema persistir, entre em contato o Owner da Api.", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
                @ApiResponse(responseCode = "204", description = "Informacoes nao encontradas.")
        }
)
public interface AfinidadeDocument {

	@Operation(summary = "Inclusão de afinidades.")
	@ApiResponse(responseCode = "201", description = "Ok")
	void adicionaAfinidade(@Valid AfinidadeRequestModel afinidadeRequest);

}