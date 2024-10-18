package challenge.vivo.apivivo.core.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.vivo.apivivo.core.dtos.ProductCreateDto;
import challenge.vivo.apivivo.core.dtos.ProductDto;
import challenge.vivo.apivivo.core.entities.Product;
import challenge.vivo.apivivo.core.mapper.ProductMapper;
import challenge.vivo.apivivo.core.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ProductController {
  private final ProductMapper productMapper;
  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<ProductDto>> getAll(){
    List<ProductDto> resultList = productService.findAll().stream().map(productMapper::map).collect(Collectors.toList());
    return new ResponseEntity<>(resultList, HttpStatus.OK);
  }

  @GetMapping("{id}")
  public ResponseEntity<ProductDto> findById(@PathVariable UUID id){
    if(!productService.existsById(id)){
      return ResponseEntity.notFound().build();
    }
    ProductDto dto = productMapper.map(productService.findById(id));
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductCreateDto requestDto){
    Product product = productMapper.map(requestDto);
    Product productSaved = productService.saveProduct(product);
    ProductDto responseDto = productMapper.map(productSaved);
    return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
  }
}
