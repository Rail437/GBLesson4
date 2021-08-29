package gb.spring.lesson4.service;

import gb.spring.lesson4.model.Product;
import gb.spring.lesson4.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public Product findByName(String name){
        return productRepository.findByDescription(name).orElseThrow(() -> new NoSuchElementException());
    }
    public void save(Product product) {
        productRepository.save(product);
    }
}
