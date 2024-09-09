package challenge.vivo.apivivo.core.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import challenge.vivo.apivivo.core.mapper.DescriptionMapper;
import challenge.vivo.apivivo.core.model.Description;
import challenge.vivo.apivivo.core.service.DescriptionService;
import challenge.vivo.apivivo.core.dto.DescriptionDto;
import challenge.vivo.apivivo.core.dto.DescriptionCreateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class DescriptionController {

	private final DescriptionService descriptionService;
	private final DescriptionMapper descriptionMapper;

	@GetMapping
    public ResponseEntity<List<DescriptionDTO>> getAll() {

        List<DescriptionDTO> result = descriptionService.getAll().stream().map(descriptionMapper::map).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

	@PostMapping
    public ResponseEntity<DescriptionDTO> create(@Valid @RequestBody DescriptionCreateDTO requestDto) {

        Description description = descriptionMapper.map(requestDto);

        Description descriptionSaved = descriptionService.save(description);

        DescriptionDTO responseDto = descriptionMapper.map(descriptionSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

	@GetMapping("{id}")
    public ResponseEntity<DescriptionDTO> findById(@PathVariable long id) {
        if (!descriptionService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        DescriptionDTO dto = descriptionMapper.map(descriptionService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
