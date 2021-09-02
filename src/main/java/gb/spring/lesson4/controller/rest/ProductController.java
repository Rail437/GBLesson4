package gb.spring.lesson4.controller.rest;

import gb.spring.lesson4.model.MyString;
import gb.spring.lesson4.model.Product;
import gb.spring.lesson4.model.ProductEntity;
import gb.spring.lesson4.service.CrudService;
import gb.spring.lesson4.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CrudService crudService;

    @GetMapping
    public String findAll(Model model) {
        /*crudService.init();*/ //Как сделать, чтобы он вызывал init только один раз?
        // A не каждый раз, при запросах.
        model.addAttribute("products", CrudService.findAll());
        return "myProducts";
    }

    /*@PostMapping("/")
    public String save(@ModelAttribute @Valid Product product){
        productService.save(product);
        return "redirect:";
    }*/

    @RequestMapping(params = "filter", method = RequestMethod.POST)
    public String filter(@ModelAttribute MyString product, Model model){
        model.addAttribute("products", productService.filter(product));
        return "myProducts";
    }

}
