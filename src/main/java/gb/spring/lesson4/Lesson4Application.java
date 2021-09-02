package gb.spring.lesson4;

import gb.spring.lesson4.service.CrudService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * 1. Добавить поле Производитель - Реализовать свой валидатор который проверяет компанию в каком то списке (через аннотацию @Company)
 * 2. Product code = Название продукта - Произовдитель (яблоко - Григорьевы сады) десериализовалось в 2 отдельных поля name и company
 * 3. Реализовать REST-controller , который предотсавляет возможности урпаавления товаром (сортировка, фильтры, удаление, добавление, обновление)
 */
public class Lesson4Application {
    private static final CrudService crud = new CrudService();

    public static void main(String[] args) {
        SpringApplication.run(Lesson4Application.class, args);
        crud.init();
    }
}
