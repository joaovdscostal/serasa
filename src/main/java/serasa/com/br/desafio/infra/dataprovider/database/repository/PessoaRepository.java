package serasa.com.br.desafio.infra.dataprovider.database.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import serasa.com.br.desafio.infra.dataprovider.database.entity.Pessoa;

public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {

	List<Pessoa> findAll();

}
