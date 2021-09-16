package gb.spring.lesson4.model;


import io.swagger.annotations.ApiModel;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ProductDto {
    private Long id;
    private String description;
    private Integer coast;
    private String company;

    public static ProductDto valueOf(ProductEntity product) {
        return new ProductDto(
                product.getId(),
                product.getDescription(),
                product.getCoast(),
                product.getCompany()
        );
    }

    public ProductEntity mapToProduct() {
        ProductEntity product = new ProductEntity();
        product.setId(id);
        product.setDescription(description);
        product.setCoast(coast);
        product.setCompany(company);
        return product;
    }
}
