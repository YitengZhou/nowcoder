package LeetCode.word_break2;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        HashSet<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        System.out.println(s.wordBreak("catsanddog",set));

    }
}
