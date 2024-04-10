package br.com.fiap.challenge.controllers;

import br.com.fiap.challenge.dtos.ProductDto;
import br.com.fiap.challenge.mappers.ProductMapper;
import br.com.fiap.challenge.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;


    @GetMapping("/users/{user_id}/products")
    public ResponseEntity<List<ProductDto>> findPedidosByUserId() {

        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
