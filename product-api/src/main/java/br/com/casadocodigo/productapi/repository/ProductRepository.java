package br.com.casadocodigo.productapi.repository;

import br.com.casadocodigo.productapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p.name, p.price, p.productIdentifier, p.description"
    		+" from Product p"
            +" join Category c on p.category.id = c.id"
            +" where c.id = :categoryId")
    List<Product> findProductByCategory(@Param("categoryId") final Long categoryId);

    Optional<Product> findByProductIdentifier(final String productIdentifier);
}