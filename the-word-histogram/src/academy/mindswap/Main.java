package academy.mindswap;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final String STRING_TO_ANALYSE = "You can always trust the untrustworthy because you can always trust that they will be untrustworthy. It's the trustworthy you cannot trust.";

    public static void main(String[] args) {

        WordHistogram wordHistogram = new WordHistogram();
        wordHistogram.analyseString(STRING_TO_ANALYSE);

        for (String word: wordHistogram) {
            System.out.println(word + " : " + wordHistogram.get(word));
        }

    }
}
