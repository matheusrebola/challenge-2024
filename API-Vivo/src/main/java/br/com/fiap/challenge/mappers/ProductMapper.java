package br.com.fiap.challenge.mappers;

import br.com.fiap.challenge.dtos.ProductDto;
import br.com.fiap.challenge.entities.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final ModelMapper modelMapper;

    public ProductDto map(Product product){
        ProductDto dto = modelMapper.map(product, ProductDto.class);
        return dto;
    }
}
