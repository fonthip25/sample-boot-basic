package th.mfu.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import th.mfu.domain.User;
import th.mfu.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserDTO toDto(User user);
    
    User toEntity(UserDTO userDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserDTO userDTO, @MappingTarget User user);
}


