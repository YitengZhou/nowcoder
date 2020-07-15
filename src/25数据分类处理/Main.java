import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int num1 = input.nextInt();
            String[] listI = new String[num1];
            for (int i=0;i<num1;i++){
                listI[i] = input.next();
            }
            int num2 = input.nextInt();
            String[] listR = new String[num2];
            for (int i=0;i<num2;i++){
                listR[i] = input.next();
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=0;i<num2;i++){
                list.add(Integer.parseInt(listR[i]));
            }
            Collections.sort(list);
            StringBuffer output= new StringBuffer();
            String repeat = "";
            int totalNum = 0;
            for (int i = 0;i<num2;i++){
                String de = ""+list.get(i);
                if (repeat.equals(de)){
                    continue;
                }
                int c = output.length();
                int count=0;
                for (int j = 0;j<num1;j++){
                    if (listI[j].contains(de)){
                        count++;
                        output.append(" " + j + " " + listI[j]);
                    }
                }
                if (count==0){
                    continue;
                }
                output.insert(c," " + de + " " + count);
                repeat = de;
                totalNum+= (count+1)*2;
            }
            output.insert(0,""+totalNum);
            System.out.println(output);
        }
    }
}