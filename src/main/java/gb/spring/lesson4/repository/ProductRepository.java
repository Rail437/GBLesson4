package gb.spring.lesson4.repository;

import gb.spring.lesson4.annotation.Company;
import gb.spring.lesson4.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Getter
@Repository
public class ProductRepository {
    private Map<Long, Product> productDb;
    @Company
    private List<String> companies;
    private AtomicLong counter = new AtomicLong();

    public ProductRepository() {
        this.productDb = new ConcurrentHashMap<>();
        productDb.put(1l, Product.builder()
                .id(1l)
                .description("Bulka")
                .coast(25)
                .build());
        this.companies = new CopyOnWriteArrayList<>();
        companies.add("Россия");
        companies.add("Германия");
        companies.add("США");
        companies.add("Садовод");
    }

    public List<Product> findAll() {
        return productDb.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public Optional<Product> findById(Long id) {
        return productDb.values().stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }
    public Optional<Product> findByDescription(String des) {
        return productDb.values().stream()
                .filter(it -> Objects.equals(it.getDescription(), des))
                .findFirst();
    }

    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(productDb.size() + counter.incrementAndGet());
        }
        productDb.put(product.getId(), product);
    }
    /*public void delete(Product product) {
        if (productDb.get(product) > 1) {
            productDb.get( - 1L);
        }
        productDb.remove(product.getId(), product);
    }*/
}

