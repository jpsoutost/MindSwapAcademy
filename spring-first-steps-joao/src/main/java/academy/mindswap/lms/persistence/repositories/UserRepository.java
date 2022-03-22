package academy.mindswap.lms.persistence.repositories;

import academy.mindswap.lms.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

    List<User> findByName(String username);

    @Query("Select u from User u where u.name = :name")
    List<User> findByOtherNameThatIWant(@Param("name") String username);
}
