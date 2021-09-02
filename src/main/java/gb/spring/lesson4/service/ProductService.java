package gb.spring.lesson4.service;

import gb.spring.lesson4.model.MyString;
import gb.spring.lesson4.model.Product;
import gb.spring.lesson4.model.ProductEntity;
import gb.spring.lesson4.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    public Product findById(Long id) {
        return null;
    }

    public void save(Product product) {
       // productRepository.save(product);
    }

    public List<ProductEntity> filter(MyString product) {
        List<ProductEntity> result = null;
        if(product.getDescription()!=null && !product.getDescription().isEmpty()){
           result = CrudService.findByDescription(product.getDescription());
        }
        if (product.getCompany() != null && !product.getCompany().isEmpty()){
            result = CrudService.findByCompany(product.getCompany());
        }
        if (product.getCoast() != null && !product.getCoast().isEmpty()){
            result = CrudService.findByCoast(product.getCoast());
        }
        return result;
    }
}
