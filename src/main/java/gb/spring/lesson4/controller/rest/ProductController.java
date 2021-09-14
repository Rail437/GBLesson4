package gb.spring.lesson4.controller.rest;

import gb.spring.lesson4.model.MyString;
import gb.spring.lesson4.model.ProductDto;
import gb.spring.lesson4.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final CrudService crudService;

    @GetMapping
    public List<ProductDto> findAll() {
        //model.addAttribute("products", crudService.findAll());
        List<ProductDto> productDtos = crudService.findAll();
        return productDtos;
    }


    @PostMapping
    public void save(@RequestBody ProductDto productDto) {
        crudService.save(productDto);
    }
/*
    @RequestMapping(params = "filter",method = RequestMethod.POST)
    public String filter(@ModelAttribute MyString product, Model model){
        model.addAttribute("products", crudService.filterByDescription(product));
        return "myProducts";
    }*/

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        crudService.deleteById(id);
    }

}
