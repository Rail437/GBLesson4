package gb.spring.lesson4.service;

import gb.spring.lesson4.model.MyString;
import gb.spring.lesson4.model.ProductDto;
import gb.spring.lesson4.repository.ProductRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@NoArgsConstructor
public class CrudService {
    @Autowired
    private ProductRepo productRepo;

    public CrudService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    public List<ProductDto> findAll() {
        return productRepo.findAll().stream()
                .map(ProductDto::valueOf)
                .collect(Collectors.toList());
    }

    public void save(ProductDto productDto) {
        productRepo.save(productDto.mapToProduct());
    }

    public ProductDto filterByDescription(MyString product) {
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
