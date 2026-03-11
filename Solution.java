import Application.GroupAnnagramsByNeetcode;

import java.util.*;

public class Solution {

    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String choice = "";

            while (!choice.equals("0")) {
                System.out.println("Select a test to run:");
                System.out.println("1. HackerRank Country Code Format");
                System.out.println("2. NeetCode Group Anagrams");
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
    }

    private static void testFormatCountryCodeAreByHackerHank() {

    }
    private static void testGroupAnagramsByNeetCode() {
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};

        List<List<String>> result1 = GroupAnnagramsByNeetcode.groupAnagrams(strs);
        List<List<String>> result2 = GroupAnnagramsByNeetcode.groupAnagramsOptmized(strs);

        System.out.println(result1.toString());
        System.out.println(result2.toString());
    }

}
