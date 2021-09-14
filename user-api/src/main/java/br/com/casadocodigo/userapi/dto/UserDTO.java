package br.com.casadocodigo.userapi.dto;

import br.com.casadocodigo.userapi.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phone;
    private LocalDateTime createdAt;

    public static UserDTO toDTO(final User entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCpf(entity.getCpf());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}