package br.com.casadocodigo.shoppingapi.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ShopItemDTO {
    @NotBlank
    private String productIdentifier;

    @NotNull
    private BigDecimal price;
}