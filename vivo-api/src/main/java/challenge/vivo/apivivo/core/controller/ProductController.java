package challenge.vivo.apivivo.core.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.vivo.apivivo.core.mapper.ProductMapper;
import challenge.vivo.apivivo.core.model.Product;
import challenge.vivo.apivivo.core.service.ProductService;
import challenge.vivo.apivivo.core.dto.ProductCreateDto;
import challenge.vivo.apivivo.core.dto.ProductDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	private final ProductMapper productMapper;

	@GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {

        List<ProductDto> result = productService.getAll().stream().map(productMapper::map).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

	@PostMapping
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductCreateDto requestDto) {

        Product produto = productMapper.map(requestDto);

        Product produtoSaved = productService.save(produto);

        ProductDto responseDto = productMapper.map(produtoSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

	@GetMapping("{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable UUID id) {
        if (!productService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        ProductDto dto = productMapper.map(productService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
