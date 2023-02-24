package br.com.casadocodigo.shoppingapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShopDTO {
    private Long id;
    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
}