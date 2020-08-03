package Match比赛.快速排序笔试;

public class Main {

    public static void main(String[] args) {
        int[] a= {25,84,21,47,15,27,68,35,20};
        QuickSort(a,0,8);
        print(a);
    }

    private static void QuickSort(int[] arr,int low,int high) {
        if (low>=high){
            return;
        }
        int left = low, right=high;
        int pilot = arr[low];
        while (low!=high){
            for (;high>low;high--){
                if (arr[high]<pilot){
                    arr[low] = arr[high];
                    break;
                }
            }
            for(;low<high;low++){
                if (arr[low]>pilot){
                    arr[high]=arr[low];
                    break;
                }
            }
        }
        arr[low]=pilot;
        print(arr);
        QuickSort(arr,left,low-1);
        QuickSort(arr,low+1,right);
    }

    public static void print(int[] a){
        StringBuffer b = new StringBuffer();
        for (int i=0;i<9;i++){
            b.append(a[i]+" ");
        }
        System.out.println(b);
    }
    public static void swap(int[] a,int x,int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
