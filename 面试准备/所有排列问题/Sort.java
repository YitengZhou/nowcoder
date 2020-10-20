package 面试.所有排列问题;

import java.util.*;
import java.math.*;

public class Sort {
    public void bubbleSort(int[] arr){
        if (arr.length == 0){
            return;
        }
        for (int i =0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[i]){
                    swap(arr,i,j);
                }
            }
        }
    }

    public void selectSort(int[] arr){
        if (arr.length==0){
            return;
        }
        for (int i = 0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    public void insertSort(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int current = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>current){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }

    public void shellSort(int[] arr){
        int len = arr.length;
        int gap = len/2;
        while (gap>0){
            for (int i=gap;i<arr.length;i++){
                int current = arr[i];
                int preindex = i-gap;
                while (preindex>=0 && arr[preindex]>current){
                    arr[preindex+gap] = arr[preindex];
                    preindex-=gap;
                }
                arr[preindex+gap] = current;
            }
            gap/=2;
        }
    }

    public int[] mergeSort(int[] arr){
        int len = arr.length;
        if (len<2){
            return arr;
        }
        int mid = len/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,len);
        return merge(mergeSort(left),mergeSort(right));
    }

    public int[] merge(int[] left, int[] right){
        int i =0,j=0;
        int[] result = new int[left.length+right.length];
        for (int index= 0;index<result.length;index++){
            if (i>=left.length){
                result[index]= right[j++];
            }
            else if (j>=right.length){
                result[index]=left[i++];
            }
            else if (left[i]<right[j]){
                result[index] = left[i++];
            }
            else{
                result[index] = right[j++];
            }
        }
        return result;
    }

    public void quickSort(int[] arr,int left, int right){
        // 注意跳出递归条件
        if (left>=right){
            return;
        }
        int pivot = arr[left];
        int i = left, j=right;
        while (i!=j){
            for (;j>i;j--){
                if (arr[j]<pivot){
                    arr[i] = arr[j];
                    break;
                }
            }
            for (;i<j;i++){
                if (arr[i]>pivot){
                    arr[j]=arr[i];
                    break;
                }
            }
        }
        arr[i] = pivot;
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);
    }

    public void heapSort(int[] arr){
        int len = arr.length;
        if (len<2){
            return;
        }
        buildHeap(arr);
        while (len>0){
            swap(arr,0,len-1);
            len--;
            Mheap(arr,0,len);
        }
    }

    public void buildHeap(int[] arr){
        for (int i = arr.length/2-1;i>=0;i--){
            Mheap(arr,i,arr.length);
        }
    }

    public void Mheap(int[] arr,int root,int len){
        int maxIndex = root;
        if (root*2+1<len && arr[maxIndex]<arr[root*2+1]){
            maxIndex = root*2+1;
        }
        if (root*2+2<len && arr[maxIndex]<arr[root*2+2]){
            maxIndex = root*2+2;
        }
        if (root != maxIndex){
            swap(arr,root,maxIndex);
            Mheap(arr,maxIndex,len);
        }
    }

    public void countSort(int[] arr){
        if (arr.length<2){
            return;
        }
        int max=arr[0],min=arr[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
            if (arr[i]<min){
                min = arr[i];
            }
        }
        int[] bucket= new int[max-min+1];
        Arrays.fill(bucket,0);
        for (int i=0;i<arr.length;i++){
            bucket[arr[i]-min]++;
        }
        int j=0;
        for (int i=0;i<arr.length;i++){
            while(bucket[j]==0){
                j++;
            }
            arr[i] = j+min;
            bucket[j]--;
        }
    }

    public ArrayList<Integer> bucketSort(ArrayList<Integer> arr,int bucketSize){
        if (arr == null ||arr.size()<2){
            return arr;
        }
        int max=arr.get(0),min = arr.get(0);
        for (int i=0;i<arr.size();i++){
            if (arr.get(i)<min){
                min = arr.get(i);
            }
            if (arr.get(i)>max){
                max = arr.get(i);
            }
        }
        int bucketNum = (max - min)/bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < arr.size(); i++) {
            bucketArr.get((arr.get(i) - min) / bucketSize).add(arr.get(i));
        }
        for (int i = 0; i < bucketNum; i++) {
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketNum == 1)
                    bucketSize--;
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++){
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }

    public void radixSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        // 位数
        int max=arr[0];
        for (int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        int maxDight = 0;
        while(max>0){
            max/=10;
            maxDight++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for (int j=0;j<mod;j++){
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i =0;i<maxDight;i++,mod*=10,div*=10){
            for (int j = 0;j<arr.length;j++){
                int num = (arr[j] %mod)/div;
                bucketArr.get(num).add(arr[j]);
            }
            int index = 0;
            for (int j = 0;j<bucketArr.size();j++){
                for (int k = 0;k<bucketArr.get(j).size();k++){
                    arr[index++] = bucketArr.get(j).get(k);
                }
                // 注意要清空
                bucketArr.get(j).clear();
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }
}
