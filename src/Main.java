import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main{
    public static void main(String[] args) throws ParseException {
        Scanner input= new Scanner(System.in);
        int y1 = input.nextInt();
        int m1 = input.nextInt();
        int d1 = input.nextInt();
        int w1 = input.nextInt();
        int y2 = input.nextInt();
        int m2 = input.nextInt();
        int d2 = input.nextInt();
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(y1+"-"+m1+"-"+d1);
        sb2.append(y2+"-"+m2+"-"+d2);
        Date day1 = simpleFormat.parse(sb1.toString());
        Date day2 = simpleFormat.parse(sb2.toString());
        int days = (int)(day2.getTime()- day1.getTime())/(1000*60*60*24);
        System.out.println(w1 + days%7);
    }
}
