package serasa.com.br.desafio.infra.config.exception.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindException;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorResponse {

	private List<Mensagem> mensagens;
	private String causa;

	public ApiErrorResponse() {
		this.mensagens = new ArrayList<>();
	}

	public static ApiErrorResponse builder(Throwable except) {
		log.error("ApiErrorResponse", except);
		return new ApiErrorResponse();
	}

	public ApiErrorResponse cause(String cause) {
		this.causa = cause;
		return this;
	}

	public ApiErrorResponse adicionaMensagem(Mensagem mensagem) {
		this.mensagens.add(mensagem);
		return this;
	}

	public ApiErrorResponse springValidationError(BindException bindException) {
		if (bindException.hasErrors()) {
			criaMensagemDeErroValidacoes(bindException);
			criaMensagemDeErroGlobais(bindException);
		}
		return this;
	}

	private void criaMensagemDeErroValidacoes(BindException bindException) {
		bindException.getFieldErrors().stream()
				.map(erro -> Mensagem.builder().mensagem(erro.getDefaultMessage()).causa(erro.getField()).build())
				.forEach(this::adicionaMensagem);
	}

	private void criaMensagemDeErroGlobais(BindException bindException) {
		bindException.getGlobalErrors().stream()
				.map(erro -> Mensagem.builder().mensagem(erro.getDefaultMessage()).causa(erro.getObjectName()).build())
				.forEach(this::adicionaMensagem);
	}

	public ApiErrorResponse build() {
		return this;
	}

}
