package gb.spring.lesson4.controller.rest;

import gb.spring.lesson4.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestProductController {
    private final ProductService productService;

}
