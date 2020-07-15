import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int typeA=0;
        int typeB=0;
        int typeC=0;
        int typeD=0;
        int typeE=0;
        int typeWrong=0;
        int typePri =0;
        while (input.hasNext()){
            String str= input.nextLine();
            boolean valid = true;
            String[] address = str.split("~");
            String[] first = address[0].split("\\.");
            String[] second = address[1].split("\\.");
            int[] firstInt = new int[4];
            int[] secondInt = new int[4];
            if (!isValid(first)||!isValid(second)){
                typeWrong++;
                continue;
            }

            for (int i=0;i<4;i++){
                firstInt[i]= Integer.parseInt(first[i]);
                secondInt[i]= Integer.parseInt(second[i]);
                if (firstInt[i] >255|| firstInt[i] <0||secondInt[i]>255||secondInt[i]<0){
                    valid=false;
                }
            }
            if (!isValidMaskCode(secondInt)){
                typeWrong++;
                continue;
            }
            if (!valid){
                typeWrong++;
                continue;
            }
            if (firstInt[0]>=1 && firstInt[0]<=126){
                typeA++;
            }
            else if (firstInt[0]>=128 && firstInt[0]<=191){
                typeB++;
            }
            else if (firstInt[0]>=192 && firstInt[0]<=223){
                typeC++;
            }
            else if (firstInt[0]>=224 && firstInt[0]<=239){
                typeD++;
            }
            else if (firstInt[0]>=240 && firstInt[0]<=255){
                typeE++;
            }

            if (firstInt[0]==10 ||(firstInt[0]==172 && firstInt[1]>=16 &&firstInt[1]<=31)||
                    (firstInt[0]==192 && firstInt[1]==168)){
                typePri++;
            }
        }
        System.out.println(""+typeA+" "+typeB+" "+typeC+" "+typeD+" "+typeE+" "+typeWrong+" "+typePri);
    }


    private static boolean isValidMaskCode(int[] mask){
        String bi ="";
        for (int i :mask){
            String temp="";
            for (int j=0;j<8;j++){
                temp += i & 1;
                i = i >> 1;
            }
            StringBuffer strR=new StringBuffer(temp);
            bi += strR.reverse().toString();
        }
        int firstIndexOf0 = bi.indexOf("0");
        int lastIndexOf1 = bi.lastIndexOf("1");
        if (firstIndexOf0 < lastIndexOf1) {
            return false;
        }
        return true;
    }

    private static boolean isValid(String[] ip){
        if (ip==null||"".equals(ip)){
            return false;
        }
        if (ip.length!=4){
            return false;
        }
        return true;
    }
}