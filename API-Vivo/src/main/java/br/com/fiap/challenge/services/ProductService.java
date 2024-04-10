package br.com.fiap.challenge.services;

import br.com.fiap.challenge.repositorys.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jvnet.hk2.annotations.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public boolean exists(long id) {
        return false;
    }

    public Arrays findByUser(long id) {
        return null;
    }
}
