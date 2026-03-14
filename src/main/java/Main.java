import application.CountTopKElement;
import application.FormatCountryCodeAreByHackerHank;
import application.GroupAnnagramsByNeetcode;
import application.StringEncodeNDecode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equals("0")) {
            System.out.println("Select a test to run:");
            System.out.println("1. HackerRank Country Code Format");
            System.out.println("2. NeetCode Group Anagrams");
            System.out.println("3. NeetCode Counting top K elements");
            System.out.println("4. NeetCode String encode and decode");
            System.out.println("0. Exit");
            System.out.print("\nEnter choice (1 or 2): ");

            choice = scanner.nextLine();

            switch (choice) {
                case "0":
                    System.out.println("Exiting...");
                    break;
                case "1":
                    testFormatCountryCodeAreByHackerHank();
                    break;
                case "2":
                    testGroupAnagramsByNeetCode();
                    break;
                case "3":
                    testCountTopKElements();
                    break;
                case "4":
                    testStringEncodeNDecode();
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }

            if (!choice.equals("0")) {
                System.out.println("\nPress Enter to roll...");
                scanner.nextLine(); // Wait for user to press Enter
            }
        }
        scanner.close();
    }

    private static void testCountTopKElements() {
        // List of test cases (input array, k, and a description)
        Object[][] tests = {
                {new int[]{1, 1, 1, 2, 2, 3}, 2, "Standard case (1 occurs 3x, 2 occurs 2x)"},
                {new int[]{1}, 1, "Single element"},
                {new int[]{7, 7, 7, 7}, 1, "All elements identical"},
                {new int[]{1, 2, 3, 4}, 2, "All frequencies are equal (any 2 are correct)"},
                {new int[]{-1, -1, -2, -2, -2, 0}, 2, "Negative numbers and zero"},
                {new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2, "Mixed occurrences"}
        };

        for (Object[] test : tests) {
            int[] input = (int[]) test[0];
            int k = (int) test[1];
            String desc = (String) test[2];

            int[] result = CountTopKElement.topKFrequent(input, k);

            System.out.println("Test: " + desc);
            System.out.println("Input:  " + Arrays.toString(input) + " | k=" + k);
            System.out.println("Result: " + Arrays.toString(result) + "\n");
        }
    }
    private static void testFormatCountryCodeAreByHackerHank() {
        // In Java, we use List.of and Map.entry as an equivalent to C# Tuple literals
        List<Map.Entry<String, String>> testCases = List.of(
                Map.entry("Afghanistan", "700123456"),     // Code: 93
                Map.entry("American Samoa", "2581234"),    // Code: 1684
                Map.entry("Kazakhstan", "701123456"),      // Code: 7
                Map.entry("Puerto Rico", "7871234567"),    // Code: 1787
                Map.entry("Dominican Republic", "809123"), // Code: 1809
                Map.entry("NonExistentCountry", "000")     // Should return -1
        );

        // %-20s is the Java equivalent of {0,-20} for left-alignment
        System.out.printf("%-20s | %-25s%n", "COUNTRY", "RESULT");
        System.out.println("-".repeat(50));

        for (Map.Entry<String, String> testCase : testCases) {
            String country = testCase.getKey();
            String phone = testCase.getValue();

            String finalResult = FormatCountryCodeAreByHackerHank.getPhoneNumbers(country, phone);

            System.out.printf("%-20s | %-25s%n", country, finalResult);
        }

        System.out.println("\nTesting complete. Press Enter to continue.");
        // In Java, we usually use a Scanner to wait for input
        new java.util.Scanner(System.in).nextLine();
    }

    private static void testGroupAnagramsByNeetCode() {
        // Array of test cases: Each case is a String array
        String[][] testCases = {
                {"act", "pots", "tops", "cat", "stop", "hat"}, // Standard case
                {"eat", "tea", "tan", "ate", "nat", "bat"},    // Classic anagram case
                {"", ""},                                      // Empty strings
                {"a"},                                         // Single character
                {"boo", "bob"},                                // Same length, not anagrams
                {"listen", "silent", "hello", "world"}         // Long words vs unique words
        };

        for (int i = 0; i < testCases.length; i++) {
            String[] input = testCases[i];

            System.out.println("--- Test Case " + (i + 1) + " ---");
            System.out.println("Input: " + Arrays.toString(input));

            List<List<String>> result1 = GroupAnnagramsByNeetcode.groupAnagrams(input);
            List<List<String>> result2 = GroupAnnagramsByNeetcode.groupAnagramsOptmized(input);

            System.out.println("Standard:  " + result1);
            System.out.println("Optimized: " + result2);

            // Quick check to see if both methods produce the same number of groups
            boolean sameSize = result1.size() == result2.size();
            System.out.println("Group Count Match: " + sameSize + "\n");
        }
    }

    private static void testStringEncodeNDecode() {
        System.out.println("Original: [" + "\"hello\", \"world\"" + "]");
        // Encode
        String encoded = StringEncodeNDecode.encode(Arrays.asList("hello", "world"));
        System.out.println("Encoded: " + encoded);

        // Decode
        List<String> decoded = StringEncodeNDecode.decode(encoded);
        System.out.println("Decoded: " + decoded);


        System.out.println("Original: [" + "\"5,3#\", \"safe,pass#word\", \"!!!\"" + "]");
        // Encode
        encoded = StringEncodeNDecode.encode(Arrays.asList("5,3#", "safe,pass#word", "!!!"));
        System.out.println("Encoded: " + encoded);

        // Decode
        decoded = StringEncodeNDecode.decode(encoded);
        System.out.println("Decoded: " + decoded);

        System.out.println("Original: [" + "\"\", \"a\", \"bc\", \"def\"" + "]");
        // Encode
        encoded = StringEncodeNDecode.encode(Arrays.asList("", "a", "bc", "def"));
        System.out.println("Encoded: " + encoded);

        // Decode
        decoded = StringEncodeNDecode.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }

}