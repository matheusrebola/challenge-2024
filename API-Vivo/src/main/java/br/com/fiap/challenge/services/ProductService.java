package br.com.fiap.challenge.services;

import br.com.fiap.challenge.repositorys.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jvnet.hk2.annotations.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ProductService implements Product {

    private final ProductRepository productRepository;
    
    @Override
    public boolean exists(long id) {
        return false;
    }

    public Arrays findByUser(long id) {
        return null;
    }

}
