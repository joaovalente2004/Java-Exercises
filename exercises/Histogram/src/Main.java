public class Main {

    private static final String STRING = "test word words test 1 10 1 ";

    public static void main(String[] args) {
        WordHistogramComp wordHistogram = new WordHistogramComp(STRING);

        System.out.println("Map has " + wordHistogram.map.size() + " distinct words");

        for (Object word : wordHistogram) {

            System.out.println(word + " : " + wordHistogram.map.get(word));
        }
    }
}
