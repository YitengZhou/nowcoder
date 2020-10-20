import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
    public void bubbleSort(int[] arr){
        for (int i =0;i<arr.length-1;i++){
            for (int j = i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }
    public void selectSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
        }
    }
    public void insertSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int val = arr[i];
            int preIndex = i-1;
            while(preIndex>=0 && arr[preIndex]>val){
                    arr[preIndex+1] = arr[preIndex];
                    preIndex--;
            }
            arr[preIndex+1] = val;
        }
    }

    public void shellSort(int[] arr){
        int len = arr.length/2;
        while (len>0){
            for (int i = len;i<arr.length;i++){
                int val = arr[i];
                int preIndex = i - len;
                while (preIndex>=0 && arr[preIndex]>val){
                    arr[preIndex+len] = arr[preIndex];
                    preIndex -= len;
                }
                arr[preIndex+len] = val;
            }
            len /=2;
        }
    }

    public int[] mergeSort(int[] arr){
        if (arr.length<2){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    public int[] merge(int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        int l=0;
        int r=0;
        for (int i = 0;i<result.length;i++){
            if (l>=left.length){
                result[i]= right[r++];
            }
            else if (r>=right.length){
                result[i] = left[l++];
            }
            else if (left[l]<right[r]){
                result[i] = left[l++];
            }
            else{
                result[i] = right[r++];
            }
        }
        return result;
    }

    public void quickSort(int[] arr,int start, int end){
        if (start>=end){
            return;
        }
        int pivot = arr[start];
        int low = start,high = end;
        while (low<high){
            for (;high>low;high--){
                if (arr[high]<pivot){
                    arr[low] =arr[high];
                    break;
                }
            }
            for (;low<high;low++){
                if (arr[low]>pivot){
                    arr[high] = arr[low];
                    break;
                }
            }
        }
        arr[low] = pivot;
        quickSort(arr,start,low-1);
        quickSort(arr,low+1,end);

    }

    public void heapSort(int[] arr){
        build(arr);
        int len = arr.length-1;
        while (len>0){
            swap(arr,0,len);
            adapt(arr,0,len);
            len--;
        }
    }
    public void build(int[] arr){
        for (int i = (arr.length-1)/2;i>=0;i--){
            adapt(arr,i,arr.length);
        }
    }

    public void adapt(int[] arr,int root,int len){
        int maxIndex = root;
        int left = root*2+1;
        int right = root*2+2;
        if (left<len && arr[left] >arr[maxIndex]){
            maxIndex = left;
        }
        if (right<len && arr[right] >arr[maxIndex]){
            maxIndex = right;
        }
        if (maxIndex!=root){
            swap(arr,root,maxIndex);
            adapt(arr,maxIndex,len);
        }
    }

    public void countSort(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int i =0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
            if (arr[i]<min){
                min = arr[i];
            }
        }
        int num = max-min+1;
        int[] result = new int[num];
        for (int i = 0;i<arr.length;i++){
            result[arr[i]-min]++;
        }
        int s = 0;
        for (int i =0;i<arr.length;i++){
            while (result[s]==0){
                s++;
            }
            arr[i] = s+min;
            result[s]--;
        }
    }

    public ArrayList<Integer> bucketSort(ArrayList<Integer> arr,int bucketSize){
        if (arr.size()<2){
            return arr;
        }
        int max = arr.get(0);
        int min = arr.get(0);
        for (int i =0;i<arr.size();i++){
            if (arr.get(i)>max){
                max = arr.get(i);
            }
            if (arr.get(i)<min){
                min = arr.get(i);
            }
        }
        int bucketNum = (max-min)/bucketSize+1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i =0;i<bucketNum;i++){
            bucketArr.add(new ArrayList<>());
        }
        for (int i = 0;i<arr.size();i++){
            bucketArr.get((arr.get(i)-min)/bucketSize).add(arr.get(i));
        }
        for (int i=0;i<bucketNum;i++){
            if (bucketSize==1){
                for (int j = 0;j<bucketArr.get(i).size();j++){
                    result.add(bucketArr.get(i).get(j));
                }
            }
            else{
                if (bucketNum==1){
                    bucketSize--;
                }
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i),bucketSize);
                for (int j =0;j<temp.size();j++){
                    result.add(temp.get(j));
                }

            }
        }
        return result;
    }

    public void radixSort(int[] arr){
        int max = arr[0];
        for (int i =0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        int loop =0;
        while (max>0){
            loop++;
            max/=10;
        }
        int div=1,mod=10;
        ArrayList<ArrayList<Integer>> container = new ArrayList<>();
        for (int i =0;i<10;i++){
            container.add(new ArrayList<>());
        }
        for (int i =0;i<loop;i++,mod*=10,div*=10){
            for (int j = 0;j<arr.length;j++){
                container.get(arr[j]%mod/div).add(arr[j]);
            }
            int n=0;
            for (int j = 0;j<container.size();j++){
                for (int k = 0;k<container.get(j).size();k++){
                    arr[n++] = container.get(j).get(k);
                }
                container.get(j).clear();
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
