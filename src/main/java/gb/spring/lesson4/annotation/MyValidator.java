package gb.spring.lesson4.annotation;

import gb.spring.lesson4.annotation.MyProductTitleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MyProductTitleValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyValidator {
    String message() default "Invalid product title";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
