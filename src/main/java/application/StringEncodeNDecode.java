package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringEncodeNDecode {
    public static String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();

        for(String str : strs)
            res.append(str.length()).append(',');

        res.append('#');

        for(String str : strs)
            res.append(str);

        return res.toString();
    }

    public static List<String> decode(String str) {
        if (str.length() == 0) return new ArrayList<>();

        List<String> result = new ArrayList<>();

        // 012345678901
        // 5,3#hellomom
        // divisor = 3
        // split [5,5]
        // substring 4, 8
        // substring 9, 11
        int divisor = str.indexOf('#');

        List<Integer> counters = Arrays
                .stream(str.substring(0, divisor).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int pointer = divisor + 1;
        for(Integer c : counters) {
            result.add(str.substring(
                    pointer,
                    pointer + c
            ));

            pointer += c;

        }

        return result;

    }
}
