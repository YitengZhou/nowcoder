import java.util.*;

public class Solution {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean IsValidExp (String s) {
        // write code here
        if (s==null || s.equals("")){
            return true;
        }
        if (s.length()%2!=0){
            return false;
        }
        Stack<Character> map = new Stack<>();
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i) == '{' || s.charAt(i) == '['||s.charAt(i) == '('){
                map.push(s.charAt(i));
            }
            else{
                if (s.charAt(i)=='}' && map.peek() == '{'){
                    map.pop();
                }
                else if (s.charAt(i)==']' && map.peek() == '{'){
                    map.pop();
                }
                else if (s.charAt(i)==')' && map.peek() == '('){
                    map.pop();
                }
                else if (s.charAt(i)==' '){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        if (map.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}