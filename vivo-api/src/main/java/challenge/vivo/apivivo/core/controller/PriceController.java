package challenge.vivo.apivivo.core.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.vivo.apivivo.core.dto.PriceDto;
import challenge.vivo.apivivo.core.mapper.PriceMapper;
import challenge.vivo.apivivo.core.service.PriceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
public class PriceController {

	private final PriceService priceService;
	private final PriceMapper priceMapper;

	@GetMapping
    public ResponseEntity<List<PriceDto>> getAll() {

        List<PriceDto> result = priceService.getAll().stream().map(priceMapper::map).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

	@GetMapping("{id}")
    public ResponseEntity<PriceDto> findById(@PathVariable UUID id) {
        if (!priceService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        PriceDto dto = priceMapper.map(priceService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
