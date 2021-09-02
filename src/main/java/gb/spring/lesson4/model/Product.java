package gb.spring.lesson4.model;

import gb.spring.lesson4.annotation.MyValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    @NotNull
    @MyValidator
    private String productCode;
    @NotNull
    private Integer coast;

    private String description;

    private String company;
}
