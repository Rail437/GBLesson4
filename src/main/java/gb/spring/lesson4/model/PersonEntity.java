package gb.spring.lesson4.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Persons")
@NamedQueries({
        @NamedQuery(name = "byIdSelect", query = "select s from PersonEntity s where s.id = :id")
})
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity products;
}
