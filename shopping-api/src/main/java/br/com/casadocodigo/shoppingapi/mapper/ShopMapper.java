package br.com.casadocodigo.shoppingapi.mapper;

import br.com.casadocodigo.shoppingapi.dto.ShopDTO;
import br.com.casadocodigo.shoppingapi.entity.Shop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper {
    ShopDTO map(final Shop entity);
    Shop map(final ShopDTO dto);
}