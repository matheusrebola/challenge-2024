package challenge.vivo.apivivo.core.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
public class PriceController {

	private final PriceService priceService;
	private final PriceMapper priceMapper;
	private final ProductService productService;
	private final ProductMapper productMapper;

	@GetMapping
    public ResponseEntity<List<PriceDTO>> getAll() {

        List<PriceDTO> result = priceService.getAll().stream().map(productMapper::map).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

	@GetMapping("{id}/product")
    public ResponseEntity<List<PriceDTO>> findProductByPriceId(@PathVariable long id) {
        if (!productService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        List<PriceDTO> dto = productService.findByCliente(id).stream().map(productMapper::map).collect(Collectors.toList());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

	@GetMapping("{id}")
    public ResponseEntity<PriceDTO> findById(@PathVariable long id) {
        if (!priceService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        PriceDTO dto = productMapper.map(priceService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
