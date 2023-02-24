package br.com.casadocodigo.shoppingapi.mapper;

import br.com.casadocodigo.shoppingapi.dto.ShopItemDTO;
import br.com.casadocodigo.shoppingapi.entity.Shop;
import br.com.casadocodigo.shoppingapi.entity.ShopItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopItemMapper {
    ShopItemDTO map(final Shop entity);
    ShopItem map(final ShopItemDTO dto);
}