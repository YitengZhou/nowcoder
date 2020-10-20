import java.util.*;
public class Main{
    public static void main(String[] args) {
        KMP kmp = new KMP("aaab");
        System.out.println(kmp.search("aaacaaab"));
    }
}