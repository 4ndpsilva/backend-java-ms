package br.com.casadocodigo.productapi.mapper;

import br.com.casadocodigo.productapi.dto.ProductDTO;
import br.com.casadocodigo.productapi.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product map(ProductDTO dto);
    ProductDTO map(Product entity);
}