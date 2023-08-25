import java.util.HashMap;

public class WordHistogramComp {

    HashMap<String, Integer> map = new HashMap<>();

    public WordHistogramComp(String string){
        String[] words = string.split(" ");
        for (String word : words) {
            add(word);
        }
    }

    public void add(String word){
        if (map.containsKey(word)) {
            int count = map.get(word);
            map.put(word, count + 1);
        } else {
            map.put(word, 1);
        }
    }
}
