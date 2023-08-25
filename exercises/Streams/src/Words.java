import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Words {
    public static void main(String[] args) {
        String filePath = "resources/text.txt";
        int n = 12; // Specify the minimum number of characters required

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Set<String> wordsSet = new HashSet<>();
            Queue<String> longestWords = new PriorityQueue<>(n, Comparator.comparingInt(String::length).reversed());

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words)
                {
                    wordsSet.add(word);
                    longestWords.offer(word);
                    if (longestWords.size() > n) {
                        longestWords.poll();
                    }
                }
            }
            //check words have in the file

            Stream<String> stream1 = wordsSet.stream();
            System.out.println("Number of words in the first file: " + stream1.count());
            stream1.close();


            System.out.println("First word longer than " + n + " characters:");

            Stream<String> stream = wordsSet.stream();
            stream.filter(word -> word.length() > n).findFirst().ifPresent(System.out::println);
            stream.close();


            //check 5 longest words in the file

            Stream<String> stream2 = wordsSet.stream();

            String longestWord = stream2.filter(word -> word.length() > n).collect(Collectors.joining(" , "));
            System.out.println("Longest words in the file: " + "{ " + longestWord + " }");
            stream2.close();


            String filePath2 = "resources/text2.txt";
            try (BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {
                Set<String> wordsSet2 = new HashSet<>();
                while ((line = reader2.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        wordsSet2.add(word);
                    }
                }

                System.out.println("Number of words in the second file: " + wordsSet2.size());
                System.out.println("");

                Set<String> commonWords = new HashSet<>(wordsSet);
                commonWords.retainAll(wordsSet2);

                System.out.println("Common words between the two files:");
                Stream<String> stream3 = commonWords.stream();
                stream3.reduce((word1, word2) -> word1 + ", " + word2).ifPresent(System.out::println);
                System.out.println("");
                System.out.println("Number of common words between the two files: " + commonWords.size());
                stream3.close();

            } catch (IOException e) {
                System.out.println(e);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
