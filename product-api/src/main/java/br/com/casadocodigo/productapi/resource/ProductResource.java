package br.com.casadocodigo.productapi.resource;

import br.com.casadocodigo.productapi.dto.ProductDTO;
import br.com.casadocodigo.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductResource {
	private final ProductService service;
	
	@PostMapping
	public ResponseEntity<ProductDTO> save(@RequestBody @Valid final ProductDTO requestDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(requestDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable final Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable final Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping("/{identifier}")
	public ResponseEntity<ProductDTO> findByProductIdentifier(@PathVariable final String identifier){
		return ResponseEntity.ok(service.findByProductIdentifier(identifier));
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<List<ProductDTO>> findByCategoryId(@PathVariable final Long categoryId){
		return ResponseEntity.ok(service.findByCategoryId(categoryId));
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(@PathVariable final Long categoryId){
		return ResponseEntity.ok(service.findAll());
	}
}