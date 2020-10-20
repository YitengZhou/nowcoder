import java.util.Scanner;
public class Main {
    public static class NodeList{
        long val;
        NodeList next;
        NodeList(long val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int one = input.nextInt();
        NodeList oneHead= new NodeList(0);
        NodeList oneStart = oneHead;
        for (int i = 0;i<one;i++){
            long value = input.nextLong();
            NodeList temp = new NodeList(value);
            oneHead.next=temp;
            oneHead = oneHead.next;
        }
        oneStart = oneStart.next;
        int second = input.nextInt();
        NodeList secondHead= new NodeList(0);
        NodeList secondStart = secondHead;
        for (int i = 0;i<second;i++){
            long value = input.nextLong();
            NodeList temp = new NodeList(value);
            secondHead.next=temp;
            secondHead = secondHead.next;
        }
        secondStart = secondStart.next;
        StringBuffer output = new StringBuffer();
        while (oneStart!=null || secondStart!=null){
            if (oneStart!=null && secondStart==null){
                oneStart = oneStart.next;

                continue;
            }
            if (oneStart==null && secondStart!=null){
                secondStart = secondStart.next;
                continue;
            }
            if (oneStart.val==secondStart.val){
                output.append(oneStart.val+" ");
                oneStart = oneStart.next;
                secondStart = secondStart.next;
            }
            else if (oneStart.val>secondStart.val){
                oneStart = oneStart.next;
            }
            else{
                secondStart = secondStart.next;
            }
        }
        System.out.println(output);
    }
}
