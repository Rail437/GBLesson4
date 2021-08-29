package gb.spring.lesson4.repository;

import gb.spring.lesson4.annotation.Company;
import gb.spring.lesson4.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private Map<Long, Product> productDb;
    private AtomicLong counter = new AtomicLong();
    private List<String> companies;


    public ProductRepository() {
        this.productDb = new ConcurrentHashMap<>();
        this.companies = new CopyOnWriteArrayList<>();
        productDb.put(1l, Product.builder()
                .id(1l)
                .description("Bulka")
                .company("Йола")
                .coast(25)
                .build());
        companies.add("Сады придонья");
        companies.add("Простоквашино");
        companies.add("Яшкино");
        companies.add("Йола");
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
            product.setDescription(Arrays.stream(product.getProductCode().split("\\s+")).limit(1).collect(Collectors.joining()));
            product.setCompany(Arrays.stream(product.getProductCode().split("\\s+")).skip(2).limit(1).collect(Collectors.joining()));
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

