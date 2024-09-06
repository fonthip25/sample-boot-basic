package th.mfu.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import th.mfu.domain.Genre;
import th.mfu.dto.GenreDTO;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    
    GenreDTO toDto(Genre genre);
    
    Genre toEntity(GenreDTO genreDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGenreFromDto(GenreDTO genreDTO, @MappingTarget Genre genre);
}