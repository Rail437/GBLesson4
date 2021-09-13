package gb.spring.lesson4.controller.rest;

import gb.spring.lesson4.model.MyString;
import gb.spring.lesson4.model.ProductEntity;
import gb.spring.lesson4.model.ProductID;
import gb.spring.lesson4.service.CrudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final CrudService crudService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", crudService.findAll());
        return "myProducts";
    }

    @RequestMapping(params = "find",method = RequestMethod.POST)
    public String save(@ModelAttribute ProductEntity product){
        crudService.save(product);
        return "redirect:";
    }

    @RequestMapping(params = "filter",method = RequestMethod.POST)
    public String filter(@ModelAttribute MyString product, Model model){
        model.addAttribute("products", crudService.filterByDescription(product));
        return "myProducts";
    }
    @RequestMapping(params = "delete",method = RequestMethod.POST)
    public String filter(@ModelAttribute ProductID product){
        crudService.deleteById(product.getId());
        return "redirect:";
    }

}
