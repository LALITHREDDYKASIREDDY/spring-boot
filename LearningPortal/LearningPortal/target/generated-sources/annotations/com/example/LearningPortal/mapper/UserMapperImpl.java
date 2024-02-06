package com.example.LearningPortal.mapper;

import com.example.LearningPortal.model.User;
import com.example.LearningPortal.modeldto.UserDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T21:02:35+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto modelToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setAccountType( user.getAccountType() );
        userDto.setEmail( user.getEmail() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setUserId( user.getUserId() );

        return userDto;
    }

    @Override
    public User dtoToModel(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setAccountType( userDto.getAccountType() );
        user.setEmail( userDto.getEmail() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setUserId( userDto.getUserId() );

        return user;
    }
}
