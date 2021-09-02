package gb.spring.lesson4.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Products")
@NamedQueries({
        @NamedQuery(name = "byIdSelect", query = "select s from ProductEntity s where s.id = :id")
})
public class ProductEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "coast")
    private Integer coast;

    @Column(name = "company")
    private String company;

    public ProductEntity(Long id, String description, Integer coast, String company) {
        this.id = id;
        this.description = description;
        this.coast = coast;
        this.company = company;
    }
    public ProductEntity(String description, Integer coast, String company) {
        this.description = description;
        this.coast = coast;
        this.company = company;
    }

    public ProductEntity() {
    }

    @Override
    public String toString() {
        return String.format("ProductEntity [id = %d, description = %s, coast = %d, company = %s]", id, description, coast, company);
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCoast() {
        return coast;
    }

    public void setCoast(Integer coast) {
        this.coast = coast;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
