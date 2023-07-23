package br.com.casadocodigo.shoppingapi.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_SHOP")
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_IDENTIFIER")
    private String userIdentifier;

    @Column(name = "DATE_BUY")
    private LocalDateTime date;

    @Column(name = "TOTAL")
    private BigDecimal total;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "SHOP_ITEM", joinColumns = @JoinColumn(name = "SHOP_ID"))
    private List<ShopItem> items;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @PrePersist
    public void calculateTotal(){
        total = items.stream()
                .map(ShopItem::getPrice)
                .reduce(BigDecimal.ZERO, (subTotal, i) -> subTotal.add(i));
    }
}