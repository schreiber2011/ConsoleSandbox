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
        int[] input = new int[] {1, 2, 2, 3, 3, 3};

        int[] result = CountTopKElement.topKFrequent(input, 2);

        System.out.println(Arrays.toString(result));
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
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};

        List<List<String>> result1 = GroupAnnagramsByNeetcode.groupAnagrams(strs);
        List<List<String>> result2 = GroupAnnagramsByNeetcode.groupAnagramsOptmized(strs);

        System.out.println(result1);
        System.out.println(result2);
    }

    private static void testStringEncodeNDecode() {
        // Encode
        String encoded = StringEncodeNDecode.encode(Arrays.asList("hello", "world"));
        System.out.println("Encoded: " + encoded);

        // Decode
        List<String> decoded = StringEncodeNDecode.decode(encoded);
        System.out.println("Decoded: " + decoded);


        // Encode
        encoded = StringEncodeNDecode.encode(Arrays.asList("5,3#", "safe,pass#word", "!!!"));
        System.out.println("Encoded: " + encoded);

        // Decode
        decoded = StringEncodeNDecode.decode(encoded);
        System.out.println("Decoded: " + decoded);

        // Encode
        encoded = StringEncodeNDecode.encode(Arrays.asList("", "a", "bc", "def"));
        System.out.println("Encoded: " + encoded);

        // Decode
        decoded = StringEncodeNDecode.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }

}

