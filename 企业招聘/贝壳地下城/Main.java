import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] kill = new int[2*num];
        int[] heal = new int[2*num];
        for (int i = 0;i<2*num;i++){
            kill[i] = input.nextInt();
        }
        for (int i = 0;i<2*num;i++){
            heal[i] = input.nextInt();
        }
        int health = 0;
        int max = 0;
        int left = num-1;
        int right = num;
        int count =0;
        while (count!=2*num){
            if (left<0){
                health-=kill[right];
                max = Math.max(max,1-health);
                health+=heal[right];
                right++;
                count++;
                continue;
            }
            if (right==2*num){
                health-=kill[left];
                max = Math.max(max,1-health);
                health+=heal[left];
                left--;
                count++;
                continue;
            }
            if (kill[left]<kill[right]){
                health-=kill[left];
                max = Math.max(max,1-health);
                health+=heal[left];
                left--;
                count++;
            }
            else{
                health-=kill[right];
                max = Math.max(max,1-health);
                health+=heal[right];
                right++;
                count++;
            }
        }
        max = Math.max(max,1-health);
        System.out.println(max);

//        StringBuffer map = new StringBuffer();
//        for (int i = 0;i<2*num;i++){
//            map.append(kill[i]+" ");
//        }
//        map.append("\n");
//        for (int i = 0;i<2*num;i++){
//            map.append(heal[i]+" ");
//        }
//        System.out.println(map);
    }
}