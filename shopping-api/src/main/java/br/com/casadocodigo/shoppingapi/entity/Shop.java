package br.com.casadocodigo.shoppingapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.Table;
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

    @Column(name = "DATE")
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