package challenge.vivo.apivivo.core.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import challenge.vivo.apivivo.core.dtos.PriceCreateDto;
import challenge.vivo.apivivo.core.dtos.PriceDto;
import challenge.vivo.apivivo.core.entities.Price;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PriceMapper {
  private final ModelMapper modelMapper;

  public Price map(PriceCreateDto dto){
    Price price = modelMapper.map(dto, Price.class);
    return price;
  }

  public PriceDto map(Price price){
    PriceDto dto = modelMapper.map(price, PriceDto.class);
    return dto;
  }
}
