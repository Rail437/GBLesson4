package gb.spring.lesson4.service;

import gb.spring.lesson4.model.MyString;
import gb.spring.lesson4.model.ProductEntity;
import gb.spring.lesson4.repository.PersonRepo;
import gb.spring.lesson4.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductRepo productRepo;
    private PersonRepo personRepo;

    public ProductService(ProductRepo productRepo, PersonRepo personRepo) {
        this.productRepo = productRepo;
        this.personRepo = personRepo;
    }

    public List<ProductEntity> filter(MyString product) {
        List<ProductEntity> result = null;
        if(product.getDescription()!=null && !product.getDescription().isEmpty()){
           result = (List<ProductEntity>) productRepo.findByDescription(product.getDescription());
        }
        if (product.getCompany() != null && !product.getCompany().isEmpty()){
            result = (List<ProductEntity>) productRepo.findByCompany(product.getCompany());
        }
        if (product.getCoast() != null && !product.getCoast().isEmpty()){
            result = (List<ProductEntity>) productRepo.findByCoast(Integer.parseInt(product.getCoast()));
        }
        return result;
    }

    public void save(ProductEntity product) {
        productRepo.save(product);
    }

    public List<ProductEntity> findAll() {
        return productRepo.findAll();
    }
}
