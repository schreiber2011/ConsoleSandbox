package Application;

import java.util.*;

public class GroupAnnagramsByNeetcode {
    public static List<List<String>> groupAnagrams(String[] strs) {
        boolean[] checked = new boolean[strs.length];
        List<List<String>> output = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            List<String> tempSubList = new ArrayList<>();
            if (checked[i]) continue;

            tempSubList.add(strs[i]);
            checked[i] = true;

            char[] iChars = strs[i].toCharArray();
            Arrays.sort(iChars);
            String sortedElementi = new String(iChars);
            for(int j = i + 1; j < strs.length; j++) {
                if(!checked[j]) {
                    String tempj = new String(strs[j]);
                    char[] jChars = strs[j].toCharArray();
                    Arrays.sort(jChars);
                    String sortedElementj = new String(jChars);
                    if (sortedElementi.equals(sortedElementj)) {
                        tempSubList.add(tempj);
                        checked[j] = true;
                    }
                }
            }
            output.add(tempSubList);
        }

        return output;
    }


    public static List<List<String>> groupAnagramsOptmized(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }

}
