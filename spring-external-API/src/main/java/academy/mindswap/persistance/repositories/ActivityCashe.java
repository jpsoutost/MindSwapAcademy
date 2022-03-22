package academy.mindswap.persistance.repositories;

import academy.mindswap.persistance.models.Activity;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ActivityCashe {

    private Set<Activity> activityCashe;

    public ActivityCashe() {
        this.activityCashe = new HashSet<>();
    }

    public List<Activity> findByType(String type){
        return activityCashe.stream().filter(a -> type.equals(a.getType())).collect(Collectors.toList());
    }

    public void add (List<Activity> activities){
        activityCashe.addAll(activities);
    }
}
