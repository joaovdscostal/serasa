package serasa.com.br.desafio.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import serasa.com.br.desafio.core.dto.PessoaDTO;
import serasa.com.br.desafio.core.dto.PessoaScoreDTO;
import serasa.com.br.desafio.infra.dataprovider.database.entity.Pessoa;
import serasa.com.br.desafio.presentation.model.request.PessoaRequestModel;
import serasa.com.br.desafio.presentation.model.response.PessoaCidadeResponseModel;
import serasa.com.br.desafio.presentation.model.response.PessoaTelefoneResponseModel;

@Mapper(componentModel = "spring")
public interface PessoaModelMap {

	PessoaDTO requestModelToDto(PessoaRequestModel model);

	@Mapping(target = "id", ignore = true)
    @Mapping(target = "dataInclusao", ignore = true)
	Pessoa DTOToEntity(PessoaDTO pessoaDTO);

	PessoaDTO entityToDTO(Pessoa pessoa);

	PessoaTelefoneResponseModel pessoaScoreDTOToPessoaTelefoneResponseModel(PessoaScoreDTO pessoaScoreDTO);

	PessoaCidadeResponseModel pessoaScoreDTOToPessoaCidadeResponseModel(PessoaScoreDTO pessoaScoreDTO);
}
