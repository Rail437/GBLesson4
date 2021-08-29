package gb.spring.lesson4.model;

import gb.spring.lesson4.annotation.Company;
import gb.spring.lesson4.annotation.MyValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {
    private Long id;
    @NotNull
    @MyValidator
    private String description;
    @NotNull
    private Integer coast;

    @Company
    private String company;

}
