import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String word1 = "We Always Mekar";
        String word2 = "coding is fun";

        System.out.println("Question 1: ");
        System.out.println(Total(word1));
        System.out.println(Total(word2));
        System.out.println();

        List<String> input1 = Arrays.asList("Abc", "bCd");
        List<String> input2 = Arrays.asList("Oke", "One");
        List<String> input3 = Arrays.asList("Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti");

        System.out.println("Question 2:");
        System.out.println(groupAndSort(input1));
        System.out.println(groupAndSort(input2));
        System.out.println(groupAndSort(input3));
    }

    public static String Total(String word) {
        word = word.toLowerCase().replace(" ", "");

        HashMap<Character, Integer> wordCount = new HashMap<>();
        for (Character c : word.toCharArray()) {
            if (wordCount.containsKey(c)) {
                wordCount.put(c, wordCount.get(c) + 1);
            } else {
                wordCount.put(c, 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for (var entry : wordCount.entrySet()) {
            result.append(String.format("%c=%d, ", entry.getKey(), entry.getValue()));
        }

        return result.substring(0, result.length() - 2);
    }

    public static String groupAndSort(List<String> words){

        String mergeWord = String.join("", words);

        HashMap<Character, Integer> wordCount = new HashMap<>();
        for (char c : mergeWord.toCharArray()) {
            if (wordCount.containsKey(c)) {
                wordCount.put(c, wordCount.get(c) + 1);
            } else {
                wordCount.put(c, 1);
            }
        }

        List<Character> sortedLetters = new ArrayList<>(wordCount.keySet());
        sortedLetters.sort(Comparator.comparingInt((Character c) -> wordCount.get(c))
                .reversed()
                .thenComparing(Comparator.naturalOrder()));

        StringBuilder result = new StringBuilder();
        for (char letter : sortedLetters) {
            result.append(letter);
        }

        return result.toString();
    }
}