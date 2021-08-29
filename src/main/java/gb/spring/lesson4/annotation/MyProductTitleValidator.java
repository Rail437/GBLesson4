package gb.spring.lesson4.annotation;

import gb.spring.lesson4.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MyProductTitleValidator implements ConstraintValidator<MyValidator, String> {
    private final ProductRepository productRepository;

    @Override
    public void initialize(MyValidator validator) {
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext context) {
        return string != null && string.matches("[А-Яа-яA-Za-z]+\s-\s[А-Яа-яA-Za-z]+") && chek(string);
    }

    public boolean chek(String str){
        String checked = Arrays.stream(str.split("\\s+")).skip(2).limit(1).collect(Collectors.joining());
        List<String> find = productRepository.getCompanies();
        for (int i = 0; i < find.size() ; i++) {
            if(checked.equalsIgnoreCase(find.get(i))){
                return true;
            }
        }
        return false;
    }
}
