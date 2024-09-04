package challenge.vivo.apivivo.core.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PriceMapper {

	private final ModelMapper modelMapper;

	public PriceDTO map(Price price) {
		PriceDTO dto = modelMapper.map(cliente, PriceDTO.class);
		return dto;
	}
}
