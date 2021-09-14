package gb.spring.lesson4.repository;

import gb.spring.lesson4.model.ProductDto;
import gb.spring.lesson4.model.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findAll();
    Optional<ProductEntity> findById(Long id);
    ProductDto findByDescription(String d);
    ProductDto findByCoast(Integer coast);
    ProductDto findByCompany(String c);
    @Query(value = "select company from products", nativeQuery = true)
    List<String> getCompany();
    ProductDto deleteByDescription(String d);
}
