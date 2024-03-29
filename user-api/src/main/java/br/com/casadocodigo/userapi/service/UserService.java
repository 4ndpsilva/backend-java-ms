package br.com.casadocodigo.userapi.service;

import br.com.casadocodigo.userapi.dto.UserDTO;
import br.com.casadocodigo.userapi.entity.User;
import br.com.casadocodigo.userapi.mapper.UserMapper;
import br.com.casadocodigo.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public List<UserDTO> listAll() {
        final List<User> users = repository.findAll();
        return users.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    public UserDTO findById(final Long id) {
        return repository.findById(id)
                .map(mapper::map)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO findByCPF(final String cpf) {
        return repository.findByCpf(cpf)
                .map(mapper::map)
                .orElseThrow(() -> new RuntimeException("CPF not found"));
    }

    public List<UserDTO> findByName(final String name) {
        final List<User> users = repository.queryByNameLike(name);
        return users.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    public void delete(final Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("User not found");
        }

        repository.deleteById(id);
    }

    public UserDTO save(UserDTO dto) {
        return mapper.map(repository.save(mapper.map(dto)));
    }
}