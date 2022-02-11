package academy.mindswap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordHistogram extends ArrayList<String> {

    public Map<String, Integer> map;

    public WordHistogram(){
        this.map = new HashMap<>();
    }

    public void analyseString(String string){
        String[] wordsArray = string.split("(\s|[.,!?:;\"-])+");

        for (String s: wordsArray) {
            s = s.toLowerCase();

            if(map.containsKey(s)){
                map. put(s, map.get(s)+1);
            }else{
                map. put(s, 1);
                this.add(s);
            }
        }

    }

    public int get(String string){
        return map.get(string);
    }

}
