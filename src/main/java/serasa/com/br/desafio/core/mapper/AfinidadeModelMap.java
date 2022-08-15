package serasa.com.br.desafio.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import serasa.com.br.desafio.core.dto.AfinidadeDTO;
import serasa.com.br.desafio.infra.dataprovider.database.entity.Afinidade;
import serasa.com.br.desafio.presentation.model.request.AfinidadeRequestModel;

@Mapper(componentModel = "spring")
public interface AfinidadeModelMap {

	AfinidadeDTO requestModelToDto(AfinidadeRequestModel model);

	@Mapping(target = "id", ignore = true)
	Afinidade DTOToEntity(AfinidadeDTO afinidadeDTO);

}
