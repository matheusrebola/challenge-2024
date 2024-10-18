package challenge.vivo.apivivo.core.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.vivo.apivivo.core.dtos.PriceCreateDto;
import challenge.vivo.apivivo.core.dtos.PriceDto;
import challenge.vivo.apivivo.core.entities.Price;
import challenge.vivo.apivivo.core.mapper.PriceMapper;
import challenge.vivo.apivivo.core.repository.PriceRepository;
import challenge.vivo.apivivo.core.service.PriceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
public class PriceController {
  private final PriceRepository priceRepository;
  private final PriceMapper priceMapper;
  private final PriceService priceService;

  @GetMapping
  public ResponseEntity<List<PriceDto>> getAll(){
    List<PriceDto> resultList = priceRepository.findAll().stream().map(priceMapper::map).collect(Collectors.toList());
    return new ResponseEntity<>(resultList, HttpStatus.OK);
  }

  @GetMapping("{id}")
  public ResponseEntity<PriceDto> findById(@PathVariable UUID id){
    if (!priceService.exists(id)){
      return ResponseEntity.notFound().build();
    }

    PriceDto dto = priceMapper.map(priceService.findById(id));
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

  public ResponseEntity<PriceDto> create(@Valid @RequestBody PriceCreateDto dto){
    Price price = priceMapper.map(dto);
    Price priceSaved = priceService.savePrice(price);
    PriceDto responseDto = priceMapper.map(priceSaved);
    return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
  }

}
