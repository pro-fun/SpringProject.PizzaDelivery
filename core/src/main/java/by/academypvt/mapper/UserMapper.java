package by.academypvt.mapper;

import by.academypvt.domain.entity.User;
import by.academypvt.dto.user.UserCreateRequest;
import by.academypvt.dto.user.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toResponse(User user);
    User toEntityCreate(UserCreateRequest userCreateRequest);


}
