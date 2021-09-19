package gb.spring.lesson4.integrationTests;

import gb.spring.lesson4.controller.rest.ProductController;
import gb.spring.lesson4.model.ProductDto;
import gb.spring.lesson4.model.ProductEntity;
import gb.spring.lesson4.repository.ProductRepo;
import gb.spring.lesson4.service.CrudService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ControllerIntegrationTest {

    private static final String URL = "/api/v1/product";

    @MockBean
    private ProductRepo productRepo;

    @Autowired
    private CrudService crudService;

    @LocalServerPort
    private String port;

    @Autowired
    private ProductController productController;

    @Test
    public void findAllSuccess(){
        ProductEntity product = new ProductEntity(1L,"apple",100,"Yola");
        List<ProductEntity> returnDto = new ArrayList<>();
        returnDto.add(product);
        Mockito.doReturn(returnDto).when(productRepo).findAll();
        List<ProductDto> productDtos = returnDto.stream()
                .map(ProductDto::valueOf)
                .collect(Collectors.toList());
        Assertions.assertSame(productDtos, productController.findAll());
        //Тяжко писать тесты. Совсем не вдохновляет (( Что посоветуете? =)
    }
}
