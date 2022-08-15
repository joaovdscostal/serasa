package serasa.com.br.desafio.infra.dataprovider.database.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import serasa.com.br.desafio.infra.dataprovider.database.entity.Afinidade;

public interface AfinidadeRepository extends PagingAndSortingRepository<Afinidade, Long> {

	Optional<Afinidade> findByRegiao(String regiao);

}
