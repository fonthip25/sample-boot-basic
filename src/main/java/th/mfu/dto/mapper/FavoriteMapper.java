package th.mfu.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import th.mfu.domain.Favorite;
import th.mfu.dto.FavoriteDTO;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {

    // Mapping Favorite Entity to DTO
    FavoriteDTO toDto(Favorite favorite);

    // Mapping DTO to Favorite Entity
    Favorite toEntity(FavoriteDTO favoriteDTO);

    // Updating existing Favorite Entity with non-null properties from DTO
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFavoriteFromDto(FavoriteDTO favoriteDTO, @MappingTarget Favorite favorite);
}
