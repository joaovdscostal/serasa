package serasa.com.br.desafio.infra.dataprovider.gateway;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import serasa.com.br.desafio.core.dto.PessoaDTO;
import serasa.com.br.desafio.core.gateway.PessoaGateway;
import serasa.com.br.desafio.core.mapper.PessoaModelMap;
import serasa.com.br.desafio.infra.config.exception.EntityNotFoundException;
import serasa.com.br.desafio.infra.dataprovider.database.entity.Pessoa;
import serasa.com.br.desafio.infra.dataprovider.database.repository.PessoaRepository;

@Component
@RequiredArgsConstructor
public class PessoaGatewayImpl implements PessoaGateway {

	private final PessoaRepository pessoaRepository;
	private final PessoaModelMap pessoaModelMap;

	@Override
	public void adicionaPessoa(PessoaDTO pessoaDTO) {
		Pessoa pessoa = pessoaModelMap.DTOToEntity(pessoaDTO);
		inicializarParametrosDaPessoa(pessoa);
		pessoaRepository.save(pessoa);
	}

	private void inicializarParametrosDaPessoa(Pessoa pessoa) {
		pessoa.setDataInclusao(LocalDateTime.now());
	}

	@Override
	public PessoaDTO buscaPorId(Long id) {
		Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() ->  new EntityNotFoundException("Nao existe pessoa para o codigo " + id));
		return pessoaModelMap.entityToDTO(pessoa);
	}

	@Override
	public List<PessoaDTO> buscaTodasPessoas() {
		List<Pessoa> pessoas = pessoaRepository.findAll();

		if(pessoas.isEmpty()) {
			throw new EntityNotFoundException("Nao existem pessoas cadastradas!");
		}

		return pessoas.stream().map(pessoaModelMap::entityToDTO).collect(Collectors.toList());
	}

}
