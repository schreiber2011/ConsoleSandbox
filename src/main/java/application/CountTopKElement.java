package application;

import java.lang.reflect.Array;
import java.util.*;

public class CountTopKElement {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countNumbs = new HashMap<>();
        for(int n : nums) {
            countNumbs.put(
                    n, countNumbs.getOrDefault(n, 0) + 1
            );
        }
        Map.entry(1,2);
        List<Map.Entry<Integer, Integer>> computedNumbs
                = new ArrayList(countNumbs.entrySet());
        computedNumbs.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        int[] topKeys = new int[k];

        for(int c = 0; c < k; c++)
            topKeys[c] = computedNumbs.get(c).getKey();

        return topKeys;

    }

}
