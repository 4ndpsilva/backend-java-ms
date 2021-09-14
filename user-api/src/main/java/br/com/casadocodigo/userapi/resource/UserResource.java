package br.com.casadocodigo.userapi.resource;

import br.com.casadocodigo.userapi.dto.UserDTO;
import br.com.casadocodigo.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserResource {
    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable final Long id){
        final UserDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UserDTO> findByCPF(@PathVariable final String cpf){
        final UserDTO dto = service.findByCPF(cpf);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDTO>> findByName(@RequestParam(name = "name", required = true) final String name){
        final List<UserDTO> users = service.findByName(name);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody final UserDTO requestDTO){
        return new ResponseEntity<>(service.save(requestDTO), HttpStatus.CREATED);
    }
}