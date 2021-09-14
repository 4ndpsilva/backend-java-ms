package br.com.casadocodigo.productapi.entity;

import br.com.casadocodigo.productapi.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "TB_PRODUCT")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRODUCT_IDENTIFIER")
    private String productIdentifier;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public static Product toEntity(final ProductDTO dto){
        final Product entity = new Product();
        entity.setProductIdentifier(dto.getProductIdentifier());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());

        if(dto.getCategory() != null){
            entity.setCategory(Category.toEntity(dto.getCategory()));
        }

        return entity;
    }
}