package br.com.casadocodigo.shoppingapi.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ShopDTO {
    @NotBlank
    private String userIdentifier;

    @NotNull
    private BigDecimal total;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private List<ShopItemDTO> items;
}