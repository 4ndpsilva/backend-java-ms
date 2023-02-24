package br.com.casadocodigo.shoppingapi.service;

import br.com.casadocodigo.shoppingapi.dto.ShopDTO;
import br.com.casadocodigo.shoppingapi.entity.Shop;
import br.com.casadocodigo.shoppingapi.mapper.ShopMapper;
import br.com.casadocodigo.shoppingapi.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ShopRepository repository;
    private final ShopMapper mapper;

    public List<ShopDTO> listAll() {
        final List<Shop> users = repository.findAll();
        return users.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    public ShopDTO findById(final Long id) {
        return repository.findById(id)
                .map(mapper::map)
                .orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public void delete(final Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Shop not found");
        }

        repository.deleteById(id);
    }

    public ShopDTO save(ShopDTO dto) {
        return mapper.map(repository.save(mapper.map(dto)));
    }
}