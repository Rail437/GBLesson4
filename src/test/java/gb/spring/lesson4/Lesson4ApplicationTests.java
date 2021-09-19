package gb.spring.lesson4;

import gb.spring.lesson4.service.CrudService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson4ApplicationTests {
    @Autowired
    private CrudService crudService;
    @Test
    void contextLoads() {
    }

}
