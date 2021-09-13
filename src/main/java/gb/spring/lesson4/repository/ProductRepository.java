package gb.spring.lesson4.repository;

import gb.spring.lesson4.model.ProductEntity;
import gb.spring.lesson4.service.CrudService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Repository
@AllArgsConstructor
public class ProductRepository {
    private CrudService crudService;
    private AtomicLong counter = new AtomicLong();


    public ProductRepository() {
    }

    public List<ProductEntity> findAll() {
        return null;
    }


    public List<String> getCompanies() {
        return crudService.getCompanies();
    }
}

