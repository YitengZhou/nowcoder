import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            StringBuilder output= new StringBuilder();
            String pwd = input.next();
            for (int i=0;i<pwd.length();i++){
                if (Character.isUpperCase(pwd.charAt(i))){
                    int add = (Character.toLowerCase(pwd.charAt(i)) - 'a' + 1) % 26 + 'a';
                    output.append(Character.toChars(add));
                }
                else if (pwd.charAt(i)-'0'<=10 &&pwd.charAt(i)-'0'>=0){
                    output.append(pwd.charAt(i));
                }
                else if (pwd.charAt(i)=='z'||pwd.charAt(i)=='y'){
                    output.append("9");
                }
                else if (pwd.charAt(i)=='s'){
                    output.append("7");
                }
                else if (pwd.charAt(i)=='v'){
                    output.append("8");
                }
                else{
                    output.append((pwd.charAt(i) - 'a') / 3 + 2);
                }
            }
            System.out.println(output);
        }
    }
}
