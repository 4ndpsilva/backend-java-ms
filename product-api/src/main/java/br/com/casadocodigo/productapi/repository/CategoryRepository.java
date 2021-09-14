package br.com.casadocodigo.productapi.repository;

import br.com.casadocodigo.productapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> { }