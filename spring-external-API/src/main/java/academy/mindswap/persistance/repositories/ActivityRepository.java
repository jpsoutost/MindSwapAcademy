package academy.mindswap.persistance.repositories;

import academy.mindswap.persistance.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    List<Activity> findByType(String type);

    List<Activity> findByDescription(String description);

    List<Activity> findByDescriptionLike(String s);
}
