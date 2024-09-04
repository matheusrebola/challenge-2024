package challenge.vivo.apivivo.core.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	private final ProductMapper productMapper;

	@GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {

        List<ProductDTO> result = productService.getAll().stream().map(productMapper::map).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

	@PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductCreateDTO requestDto) {

        Produto produto = produtoMapper.map(requestDto);

        Produto produtoSaved = produtoService.save(produto);

        ProductDTO responseDto = produtoMapper.map(produtoSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

	@GetMapping("{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable long id) {
        if (!productService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        ProductDTO dto = productMapper.map(productService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
