package by.academypvt.mapper;

import by.academypvt.domain.entity.User;
import by.academypvt.dto.user.UserRequest;
import by.academypvt.dto.user.UserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-22T13:30:49+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setName( user.getName() );
        userResponse.setSurname( user.getSurname() );
        userResponse.setPhoneNumber( user.getPhoneNumber() );
        userResponse.setAddress( user.getAddress() );
        userResponse.setEmail( user.getEmail() );

        return userResponse;
    }

    @Override
    public User toUser(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User user = new User();

        user.setName( userRequest.getName() );
        user.setSurname( userRequest.getSurname() );
        user.setPhoneNumber( userRequest.getPhoneNumber() );
        user.setAddress( userRequest.getAddress() );
        user.setEmail( userRequest.getEmail() );
        user.setLogin( userRequest.getLogin() );
        user.setPassword( userRequest.getPassword() );

        return user;
    }
}
