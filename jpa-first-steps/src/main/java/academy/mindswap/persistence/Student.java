package academy.mindswap.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id_card")
    private Integer idCard;

    @Column(length = 50)
    private String name;

    @Column
    private Integer edition;

    public Student(){}

    public Student(Integer idCard, String name, Integer edition) {
        this.idCard = idCard;
        this.name = name;
        this.edition = edition;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idCard=" + idCard +
                ", name='" + name + '\'' +
                ", edition=" + edition +
                '}';
    }
}
