import java.util.HashMap;

public class WordHistogram extends HashMap {

    public WordHistogram(String string){
        String[] words = string.split(" ");
        for (String word : words) {
            add(word);
        }
    }

    public void add(String word){
        if (containsKey(word)) {
            int count = (int) get(word);
            put(word, count + 1);
        } else {
            put(word, 1);
        }
    }



}
