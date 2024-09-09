package challenge.vivo.apivivo.core.mapper;

import java.time.Instant;

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

	public Description map(DescriptionCreateDTO dto) {
		Description description = modelMapper.map(dto, Description.class);
		description.setDataCadastro(Instant.now());
		return description;
	}

	public DescriptionDTO map(Description description) {
		DescriptionDTO dto = modelMapper.map(cliente, DescriptionDTO.class);
		return dto;
	}
}
