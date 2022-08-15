package serasa.com.br.desafio.core.usecase.pessoa;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import serasa.com.br.desafio.core.dto.PessoaDTO;
import serasa.com.br.desafio.core.dto.PessoaScoreDTO;
import serasa.com.br.desafio.core.gateway.AfinidadeGateway;
import serasa.com.br.desafio.core.gateway.PessoaGateway;
import serasa.com.br.desafio.core.gateway.ScoreGateway;
import serasa.com.br.desafio.core.mapper.PessoaScoreMapper;

@Service
@RequiredArgsConstructor
public class BuscaPessoaPorIdInteractor implements BuscaPessoaPorIdBoundary{

	private final PessoaGateway pessoaGateway;
	private final AfinidadeGateway afinidadeGateway;
	private final ScoreGateway scoreGateway;

	@Override
	public PessoaScoreDTO execute(Long id) {
		PessoaDTO pessoa = pessoaGateway.buscaPorId(id);
		List<String> estados = afinidadeGateway.buscaEstadosPorRegiao(pessoa.getRegiao());
		String scoreDescricao = scoreGateway.buscaScoreDescricaoPorValorDoScore(pessoa.getScore());

		return PessoaScoreMapper.montarPessoaScoreAfinidade(pessoa, estados, scoreDescricao);
	}
}