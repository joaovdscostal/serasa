package serasa.com.br.desafio.infra.config.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import serasa.com.br.desafio.infra.config.exception.EntityNotFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse internal(Exception exception) {
    	return ApiErrorResponse.builder(exception)
				.adicionaMensagem(Mensagem.builder().mensagem(exception.getMessage()).build())
				.cause(exception.getClass().getSimpleName())
				.build();
    }

    @ResponseBody
    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void noContent(Exception exception) {
    	log.info("Sem conteudo para retornar", exception);
    }

    @ResponseBody
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse notValidaException(MethodArgumentNotValidException exception) {
    	ApiErrorResponse response = ApiErrorResponse.builder(exception)
    			.cause(exception.getClass().getSimpleName())
    			.build();

    	exception.getAllErrors().stream().forEach(error -> response.adicionaMensagem(Mensagem.builder().mensagem(error.getDefaultMessage()).build()));

    	return response;

    }

}