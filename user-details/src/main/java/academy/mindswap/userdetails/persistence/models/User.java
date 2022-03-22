package academy.mindswap.userdetails.persistence.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User{
    private Integer ID;
    private String name;
    private String email;

    @Override
    public String toString() {
        return "USER: -- " +
                "ID:" + ID + " | " +
                "NAME:" + name + " | " +
                "EMAIL:" + email;
    }
}