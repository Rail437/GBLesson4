package gb.spring.lesson4.repository;

import gb.spring.lesson4.model.Product;
import gb.spring.lesson4.service.CrudService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Getter
@Repository
@AllArgsConstructor
public class ProductRepository {
    private CrudService crudService;
    private AtomicLong counter = new AtomicLong();


    public ProductRepository() {
    }

    public List<Product> findAll() {
        return null;
    }


    public List<String> getCompanies() {
        return crudService.getCompanies();
    }
}

