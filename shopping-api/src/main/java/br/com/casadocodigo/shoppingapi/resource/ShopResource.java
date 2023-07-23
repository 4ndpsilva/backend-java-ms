package br.com.casadocodigo.shoppingapi.resource;

import br.com.casadocodigo.shoppingapi.dto.ShopDTO;
import br.com.casadocodigo.shoppingapi.service.ShopService;
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

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class ShopResource {
    private final ShopService service;

    @GetMapping
    public ResponseEntity<List<ShopDTO>> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> findById(@PathVariable final Long id){
        final ShopDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ShopDTO> save(@RequestBody final ShopDTO requestDTO){
        return new ResponseEntity<>(service.save(requestDTO), HttpStatus.CREATED);
    }
}