package serasa.com.br.desafio.core.usecase.pessoa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import serasa.com.br.desafio.core.dto.PessoaDTO;
import serasa.com.br.desafio.core.dto.PessoaScoreDTO;
import serasa.com.br.desafio.core.gateway.AfinidadeGateway;
import serasa.com.br.desafio.core.gateway.PessoaGateway;
import serasa.com.br.desafio.core.gateway.ScoreGateway;
import serasa.com.br.desafio.core.mapper.PessoaScoreMapper;
import serasa.com.br.desafio.infra.config.exception.EntityNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuscaTodasPessoasInteractor implements BuscaTodasPessoasBoundary{

	private final PessoaGateway pessoaGateway;
	private final AfinidadeGateway afinidadeGateway;
	private final ScoreGateway scoreGateway;

	@Override
	public List<PessoaScoreDTO> execute() {
		List<PessoaDTO> pessoas = pessoaGateway.buscaTodasPessoas();
		List<PessoaScoreDTO> retorno = new ArrayList<>();

		pessoas.forEach(pessoa -> {
			try {
				List<String> estados = afinidadeGateway.buscaEstadosPorRegiao(pessoa.getRegiao());
				String scoreDescricao = scoreGateway.buscaScoreDescricaoPorValorDoScore(pessoa.getScore());
				retorno.add(PessoaScoreMapper.montarPessoaScoreAfinidade(pessoa, estados, scoreDescricao));
			}catch (EntityNotFoundException e) {
				log.info("Registros nao encontrados para pessoa " + pessoa.getNome() + " mensagem: " + e.getMessage());
			}
		});

		return retorno;
	}
}