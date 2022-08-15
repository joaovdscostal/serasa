package serasa.com.br.desafio.presentation.entrypoint.pessoa;

import java.util.List;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import serasa.com.br.desafio.infra.config.exception.handler.ApiErrorResponse;
import serasa.com.br.desafio.presentation.model.request.PessoaRequestModel;
import serasa.com.br.desafio.presentation.model.response.PessoaCidadeResponseModel;
import serasa.com.br.desafio.presentation.model.response.PessoaTelefoneResponseModel;

@Tag(name = "Pessoa", description = "Serviço responsável pela manutenção de pessoas.")
@ApiResponses(
		value = {
                @ApiResponse(responseCode = "400", description = "Parâmetros incorretos (os dados de entradas estão incorretos ou ausentes).", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
                @ApiResponse(responseCode = "500", description = "Erro Inesperado. Se o problema persistir, entre em contato o Owner da Api.", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
                @ApiResponse(responseCode = "204", description = "Informacoes nao encontradas.")
        }
)
public interface PessoaDocument {

	@Operation(summary = "Inclusão de pessoas.")
	@ApiResponse(responseCode = "201", description = "Ok")
	void adicionaPessoa(@Valid PessoaRequestModel pessoaRequest);

	@Operation(summary = "Busca pessoa por id.")
	@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = PessoaTelefoneResponseModel.class)), description = "Pessoa retornada com sucesso.")
	public PessoaTelefoneResponseModel buscaPorId(@Parameter(description = "Id da pessoa", required = true, example = "1")Long idPessoa);

	@Operation(summary = "Busca todas as pessoas do cadastro.")
	@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = PessoaCidadeResponseModel.class)), description = "Pessoa retornada com sucesso.")
	public List<PessoaCidadeResponseModel> buscaTodasAsPessoas();

}