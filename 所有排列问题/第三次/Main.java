import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // set array
        int[] a = {3,38,5,44,15,36,26,27,2,46,4,19,50,48,23};
        ArrayList<Integer> list = new ArrayList<>();
        Sort s = new Sort();

        // Bubble Sort
        shuffle(a,list);
        System.out.println("Bubble Sort");
        print(a);
        s.bubbleSort(a);
        print(a);

        // Select Sort
        shuffle(a,list);
        System.out.println("Select Sort");
        print(a);
        s.selectSort(a);
        print(a);

        // Insert Sort
        shuffle(a,list);
        System.out.println("Insert Sort");
        print(a);
        s.insertSort(a);
        print(a);

        // Shell Sort
        shuffle(a,list);
        System.out.println("Shell Sort");
        print(a);
        s.shellSort(a);
        print(a);

        // Merge Sort
        shuffle(a,list);
        System.out.println("Merge Sort");
        print(a);
        print(s.mergeSort(a));

        // Quick Sort
        shuffle(a,list);
        System.out.println("Quick Sort");
        print(a);
        s.quickSort(a,0,a.length-1);
        print(a);

        // Heap Sort
        shuffle(a,list);
        System.out.println("Heap Sort");
        print(a);
        s.heapSort(a);
        print(a);

        // Count Sort
        int[] b = {1,1,2,2,2,2,2,2,2,3,3,4,5,6,6,7,7,8,8};
        shuffle(b,list);
        System.out.println("Count Sort");
        print(b);
        s.countSort(b);
        print(b);

        // Bucket Sort
        shuffle(a,list);
        for (int i: a){
            list.add(i);
        }
        System.out.println("Bucket Sort");
        print(list);
        print(s.bucketSort(list,2));
        list.clear();

        // Radix Sort
        shuffle(a,list);
        System.out.println("Radix Sort");
        print(a);
        s.radixSort(a);
        print(a);
    }
    public static void print(int[] arr){
        StringBuffer str = new StringBuffer();
        for (int i=0;i<arr.length;i++){
            str.append(arr[i] + " ");
        }
        System.out.println(str);
    }

    public static void print(ArrayList<Integer> list){
        StringBuffer str = new StringBuffer();
        for (int i=0;i<list.size();i++){
            str.append(list.get(i) + " ");
        }
        System.out.println(str);
    }

    public static void shuffle(int[] a,ArrayList<Integer> list){
        for (int i: a){
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i=0;i<a.length;i++){
            a[i] = list.get(i);
        }
        list.clear();
    }
}
