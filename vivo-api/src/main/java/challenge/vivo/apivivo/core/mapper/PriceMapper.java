package challenge.vivo.apivivo.core.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import challenge.vivo.apivivo.core.model.Price;
import lombok.RequiredArgsConstructor;

import challenge.vivo.apivivo.core.dto.PriceDto;

@Component
@RequiredArgsConstructor
public class PriceMapper {

	private final ModelMapper modelMapper;

	public PriceDTO map(Price price) {
		PriceDTO dto = modelMapper.map(cliente, PriceDTO.class);
		return dto;
	}
}
