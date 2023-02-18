package br.com.casadocodigo.userapi.mapper;

import br.com.casadocodigo.userapi.dto.UserDTO;
import br.com.casadocodigo.userapi.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO map(final User entity);
    User map(final UserDTO dto);
}