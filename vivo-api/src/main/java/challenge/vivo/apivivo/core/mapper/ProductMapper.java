package challenge.vivo.apivivo.core.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import challenge.vivo.apivivo.core.dto.ProductCreateDto;
import challenge.vivo.apivivo.core.dto.ProductDto;
import challenge.vivo.apivivo.core.model.Product;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductMapper {

	private final ModelMapper modelMapper;
	
	public Product map(ProductCreateDto dto) {
		Product product = modelMapper.map(dto, Product.class);
		return product;
	}
	
	public ProductDto map(Product product) {
		ProductDto dto = modelMapper.map(product, ProductDto.class);
		return dto;
	}
}
