package br.com.casadocodigo.productapi.dto;

import br.com.casadocodigo.productapi.entity.Category;
import br.com.casadocodigo.productapi.entity.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {
    @NotBlank
    private String productIdentifier;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private CategoryDTO category;

    public static ProductDTO toDTO(final Product entity){
        final ProductDTO dto = new ProductDTO();
        dto.setProductIdentifier(entity.getProductIdentifier());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());

        if(entity.getCategory() != null){
            dto.setCategory(CategoryDTO.toDTO(entity.getCategory()));
        }

        return dto;
    }
}