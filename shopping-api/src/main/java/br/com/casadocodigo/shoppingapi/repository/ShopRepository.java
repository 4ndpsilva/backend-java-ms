package br.com.casadocodigo.shoppingapi.repository;

import br.com.casadocodigo.shoppingapi.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}