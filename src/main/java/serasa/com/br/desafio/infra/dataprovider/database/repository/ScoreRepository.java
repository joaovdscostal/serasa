package serasa.com.br.desafio.infra.dataprovider.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import serasa.com.br.desafio.infra.dataprovider.database.entity.Score;

public interface ScoreRepository extends PagingAndSortingRepository<Score, Long> {

	@Query("select s from Score s where :score >= s.scoreInicial and :score <= s.scoreFinal  ")
	Optional<Score> findByScoreConsult(@Param("score") Integer score);

}
