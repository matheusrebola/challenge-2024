package challenge.vivo.apivivo.core.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import challenge.vivo.apivivo.core.dtos.ProductCreateDto;
import challenge.vivo.apivivo.core.dtos.ProductDto;
import challenge.vivo.apivivo.core.entities.Product;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductMapper {
  private final ModelMapper modelMapper;

  public Product map(ProductCreateDto dto){
    Product product = modelMapper.map(dto, Product.class);
    return product;
  }

  public ProductDto map(Product product){
    ProductDto dto = modelMapper.map(product, ProductDto.class);
    return dto;
  }
}
