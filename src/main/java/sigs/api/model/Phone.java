package sigs.api.model;

import javax.persistence.*;

@Entity
@Table(name = "phones")

//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone_name", nullable = false)
    private String phoneName;

    @Column(name = "phone_brand", nullable = false)
    private String phoneBrand;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }
}
