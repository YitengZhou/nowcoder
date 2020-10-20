import java.util.*;
import java.text.DecimalFormat;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double n = input.nextDouble();
        int m = input.nextInt();
        double r = input.nextDouble();
        for (int i = 1;i<=m;i++){
            find(i*r,n);
        }
    }
    public static void find(double position, double n){
        DecimalFormat df = new DecimalFormat("######0.00");
        double round = 4 * n;
        while (position>round){
            position-=round;
        }
        if (position<=n){
            System.out.println(df.format(position)+" "+ df.format(0));
        }
        else if (position<=2*n){
            System.out.println(df.format(n)+" "+ df.format(position-n));
        }
        else if (position<=3*n){
            System.out.println(df.format(3*n - position)+" "+ df.format(n));
        }
        else{
            System.out.println(df.format(0)+" "+ df.format(4*n-position));
        }
    }
}