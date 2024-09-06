package th.mfu.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import th.mfu.domain.Review;
import th.mfu.dto.ReviewDTO;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    
    ReviewDTO toDto(Review review);
    
    Review toEntity(ReviewDTO reviewDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateReviewFromDto(ReviewDTO reviewDTO, @MappingTarget Review review);
}
