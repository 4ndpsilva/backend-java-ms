package br.com.casadocodigo.userapi.repository;

import br.com.casadocodigo.userapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCpf(final String cpf);
    List<User> queryByNameLike(final String name);
}