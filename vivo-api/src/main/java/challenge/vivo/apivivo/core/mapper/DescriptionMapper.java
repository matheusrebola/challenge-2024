package challenge.vivo.apivivo.core.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import challenge.vivo.apivivo.core.model.Description;
import challenge.vivo.apivivo.core.dto.DescriptionCreateDto;
import challenge.vivo.apivivo.core.dto.DescriptionDto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DescriptionMapper {

	private final ModelMapper modelMapper;

	public Description map(DescriptionCreateDto dto) {
		Description description = modelMapper.map(dto, Description.class);
		return description;
	}

	public DescriptionDto map(Description description) {
		DescriptionDto dto = modelMapper.map(description, DescriptionDto.class);
		return dto;
	}
}
