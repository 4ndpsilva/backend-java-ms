package br.com.casadocodigo.productapi.dto;

import br.com.casadocodigo.productapi.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private Long id;
    private String name;

    public static CategoryDTO toDTO(final Category entity){
        final CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}