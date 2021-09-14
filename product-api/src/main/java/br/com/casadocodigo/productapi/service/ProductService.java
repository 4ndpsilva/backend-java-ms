package br.com.casadocodigo.productapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.casadocodigo.productapi.dto.ProductDTO;
import br.com.casadocodigo.productapi.entity.Product;
import br.com.casadocodigo.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ProductService {
	private final ProductRepository repository;
	
	public ProductDTO save(final ProductDTO dto) {
		return ProductDTO.toDTO(repository.save(Product.toEntity(dto)));
	}
	
	public void delete(final Long id) {
		if(!repository.existsById(id)) {
			throw new RuntimeException("Product not found");
		}
		
		repository.deleteById(id);
	}
	
	public ProductDTO findById(final Long id) {
		return repository.findById(id)
				.map(ProductDTO::toDTO)
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	public List<ProductDTO> findByCategoryId(final Long categoryId) {
		return createList(repository.findProductByCategory(categoryId));
	}
	
	public ProductDTO findByProductIdentifier(final String productIdentifier) {
		return repository.findByProductIdentifier(productIdentifier)
				.map(ProductDTO::toDTO)
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	public List<ProductDTO> findAll() {
		return createList(repository.findAll());
	}
	
	private List<ProductDTO> createList(final List<Product> entities){
		return entities.stream()
				.map(ProductDTO::toDTO)
				.collect(Collectors.toList());
	}
}