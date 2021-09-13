package gb.spring.lesson4.service;

import gb.spring.lesson4.model.MyString;
import gb.spring.lesson4.model.ProductEntity;
import gb.spring.lesson4.repository.PersonRepo;
import gb.spring.lesson4.repository.ProductRepo;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


@Service
@NoArgsConstructor
public class CrudService {
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private ProductRepo productRepo;

    public CrudService(PersonRepo personRepo, ProductRepo productRepo) {
        this.personRepo = personRepo;
        this.productRepo = productRepo;
    }


    public List<ProductEntity> findAll() {
        return productRepo.findAll();
    }

    public void save(ProductEntity product) {
        productRepo.save(product);
    }

    public ProductEntity filterByDescription(MyString product) {
        return productRepo.findByDescription(product.getDescription());
    }

    public List<String> getCompanies() {
       return productRepo.getCompany();
    }

    public void delete(String description) {
        productRepo.deleteByDescription(description);
    }

    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }
}
