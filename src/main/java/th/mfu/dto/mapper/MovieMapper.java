package th.mfu.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import th.mfu.domain.Movie;
import th.mfu.dto.MovieDTO;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    
    MovieDTO toDto(Movie movie);
    
    Movie toEntity(MovieDTO movieDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMovieFromDto(MovieDTO movieDTO, @MappingTarget Movie movie);
}

