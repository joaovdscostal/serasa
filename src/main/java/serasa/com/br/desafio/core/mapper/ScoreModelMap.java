package serasa.com.br.desafio.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import serasa.com.br.desafio.core.dto.ScoreDTO;
import serasa.com.br.desafio.infra.dataprovider.database.entity.Score;
import serasa.com.br.desafio.presentation.model.request.ScoreRequestModel;

@Mapper(componentModel = "spring")
public interface ScoreModelMap {

	ScoreDTO requestModelToDto(ScoreRequestModel model);

	@Mapping(target = "id", ignore = true)
	Score DTOToEntity(ScoreDTO scoreDTO);

}
