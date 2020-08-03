import LeetCode.word_break2.Solution;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution s =new Solution();
        HashSet<String> dict = new HashSet<>();
        dict.add("at");
        dict.add("cat");
        System.out.println(s.wordBreak("catat",dict));
    }
}
