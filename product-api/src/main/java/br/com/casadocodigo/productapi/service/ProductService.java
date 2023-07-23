package br.com.casadocodigo.productapi.service;

import br.com.casadocodigo.productapi.dto.ProductDTO;
import br.com.casadocodigo.productapi.entity.Product;
import br.com.casadocodigo.productapi.mapper.ProductMapper;
import br.com.casadocodigo.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ProductService {
	private final ProductRepository repository;
	private final ProductMapper mapper;
	
	public ProductDTO save(final ProductDTO dto) {
		return mapper.map(repository.save(mapper.map(dto)));
	}
	
	public void delete(final Long id) {
		if(!repository.existsById(id)) {
			throw new RuntimeException("Product not found");
		}
		
		repository.deleteById(id);
	}
	
	public ProductDTO findById(final Long id) {
		return repository.findById(id)
				.map(mapper::map)
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	public List<ProductDTO> findByCategoryId(final Long categoryId) {
		return createList(repository.findByCategoryId(categoryId));
	}
	
	public ProductDTO findByProductIdentifier(final String productIdentifier) {
		return repository.findByProductIdentifier(productIdentifier)
				.map(mapper::map)
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	public List<ProductDTO> findAll() {
		return createList(repository.findAll());
	}
	
	private List<ProductDTO> createList(final List<Product> entities){
		return entities.stream()
				.map(mapper::map)
				.collect(Collectors.toList());
	}
}