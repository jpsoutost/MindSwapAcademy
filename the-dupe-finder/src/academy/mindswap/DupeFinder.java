package academy.mindswap;


import java.util.*;

public class DupeFinder <T>{

    HashSet<T> set;
    List<T> list;

    public DupeFinder(List<T> fruitsList) {
        this.list = fruitsList;
        this.set = new HashSet<>(fruitsList);
    }

    public int checkDupes(){
        return this.list.size()-this.set.size();
    }

    public List<T> getDupes(){
        List<T> list = new ArrayList<>();
        this.set.clear();

        for (T object : this.list){
            if (!this.set.add(object))
            list.add(object);
        }

        return list;
    }
}
