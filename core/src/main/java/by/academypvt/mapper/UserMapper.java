package by.academypvt.mapper;

import by.academypvt.domain.entity.Order;
import by.academypvt.domain.entity.User;
import by.academypvt.dto.order.OrderRequest;
import by.academypvt.dto.user.UserCreateRequest;
import by.academypvt.dto.user.UserRequest;
import by.academypvt.dto.user.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toResponse(User user);
    User toEntity(UserRequest userRequest);
    User toEntityCreate(UserCreateRequest userCreateRequest);


}
