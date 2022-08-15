package serasa.com.br.desafio.core.dto;

import java.util.List;

import lombok.Data;

@Data
public class AfinidadeDTO {

	private String regiao;
	private List<String> estados;

}

