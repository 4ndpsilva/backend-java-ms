package br.com.casadocodigo.productapi.mapper;

import br.com.casadocodigo.productapi.dto.CategoryDTO;
import br.com.casadocodigo.productapi.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category map(CategoryDTO dto);
    CategoryDTO map(Category entity);
}