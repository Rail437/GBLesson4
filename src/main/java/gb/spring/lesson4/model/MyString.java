package gb.spring.lesson4.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MyString {

    private String description;
    private String company;
    private String coast;
}
