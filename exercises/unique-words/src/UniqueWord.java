import java.util.HashSet;

public class UniqueWord {


    HashSet<String> set = new HashSet<>();

    public UniqueWord(String string){
        String[] words = string.split(" ");
        for (String word : words) {
            add(word);
        }
    }

    public void add(String word){
        set.add(word);

    }




}
