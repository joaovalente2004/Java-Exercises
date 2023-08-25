

public class Main {

    public static final String STRING= "rui rui rui campelo campelo campelo test  abc abc abc abc abc abc abc abc";



    public static void main(String[] args) {

        UniqueWord uniqueWord = new UniqueWord(STRING);



        for (String word : uniqueWord.set){
            System.out.println(word);
        }

    }
}
