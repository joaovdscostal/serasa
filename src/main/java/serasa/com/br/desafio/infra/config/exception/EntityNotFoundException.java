package serasa.com.br.desafio.infra.config.exception;

public class EntityNotFoundException extends RuntimeException {

	public EntityNotFoundException(String string) {
		super(string);
	}

	private static final long serialVersionUID = -5351204515761013622L;

}
