package gb.spring.lesson4.controller.rest;

import gb.spring.lesson4.model.ProductDto;
import gb.spring.lesson4.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestProductController {

    private final CrudService crudService;

    /*@GetMapping
    public List<ProductDto> findAll() {
        return crudService.findAll();
    }

    @PostMapping
    public void save(@RequestBody ProductDto productDto) {
        crudService.save(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        crudService.deleteById(id);
    }*/
}
