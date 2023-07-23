package br.com.casadocodigo.shoppingapi.repository;

import br.com.casadocodigo.shoppingapi.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findAllByUserIdentifier(final String userIdentifier);

    List<Shop> findAllByTotalGreaterThan(final BigDecimal total);

    List<Shop> findAllByDateGreaterThanEqual(final LocalDateTime date);
}