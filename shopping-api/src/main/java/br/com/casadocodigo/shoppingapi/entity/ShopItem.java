package br.com.casadocodigo.shoppingapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ShopItem {
    private String productIdentifier;
    private BigDecimal price;
}