package gb.spring.lesson4.annotation;

import gb.spring.lesson4.repository.ProductRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MyProductTitleValidator implements ConstraintValidator<MyValidator, String> {
    ProductRepository productRepository;
    @Override
    public void initialize(MyValidator validator) {
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext context) {
        return string != null && string.matches("[А-Яа-яA-Za-z]+\s-\s[А-Яа-яA-Za-z]+");
                //&& Arrays.stream(string.split("\\s+")).skip(2).collect(Collectors.joining()).contains();
    }
}
