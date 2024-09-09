package challenge.vivo.apivivo.core.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import challenge.vivo.apivivo.core.dto.ProductCreateDto;
import challenge.vivo.apivivo.core.dto.ProductDto;
import challenge.vivo.apivivo.core.model.Product;
import challenge.vivo.apivivo.core.dto.ProductCreateDto;
import challenge.vivo.apivivo.core.dto.ProductDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductMapper {

	private final ModelMapper modelMapper;
	
	public Product map(ProductCreateDto dto) {
		Product acesso = modelMapper.map(dto, Product.class);
		return acesso;
	}
	
	public ProductDto map(Product acesso) {
		ProductDto dto = modelMapper.map(acesso, ProductDto.class);
		return dto;
	}
}
