import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
    public void bubbleSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }

    public void selectSort(int[] arr){
        for (int i=0;i<arr.length-1;i++) {
            int minIndex = i;
            for (int j =i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    public void insertSort(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int temp = arr[i];
            int preindex = i-1;
            while (preindex>=0 && temp<arr[preindex]){
                arr[preindex+1] = arr[preindex];
                preindex--;
            }
            arr[preindex+1] = temp;
        }
    }

    public void shellSort(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }
        int len = arr.length/2;
        while (len>0){
            for (int i=len;i<arr.length;i++){
                int temp = arr[i];
                int preIndex = i -len;
                while (preIndex>=0 && arr[preIndex]>temp){
                    arr[preIndex+len] = arr[preIndex];
                    preIndex -= len;
                }
                arr[preIndex+len] = temp;
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

    public int[] merge(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        int l =0, r=0;
        for (int i = 0;i<result.length;i++){
            if (l>=left.length){
                result[i] = right[r++];
            }
            else if (r>=right.length){
                result[i] = left[l++];
            }
            else if (left[l]<right[r]){
                result[i] = left[l++];
            }
            else {
                result[i] = right[r++];
            }
        }
        return result;
    }

    public void quickSort(int[] arr,int left, int right){
        if (left>=right){
            return;
        }
        int pivot = arr[left];
        int l = left,r = right;
        while(l!=r){
            for (;r>l;r--){
                if (arr[r]<pivot){
                    arr[l] = arr[r];
                    break;
                }
            }
            for (;l<r;l++){
                if (arr[l]>pivot){
                    arr[r] = arr[l];
                    break;
                }
            }
        }
        arr[l] = pivot;
        quickSort(arr,left,l-1);
        quickSort(arr,l+1,right);
    }

    public void heapSort(int[] arr){
        build(arr);
        int len = arr.length-1;
        while(len>0){
            swap(arr,0,len);
            adjust(arr,0,len);
            len--;
        }
    }

    public void build(int[] arr){
        for (int i= arr.length/2-1;i>=0;i--){
            adjust(arr,i,arr.length);
        }
    }

    public void adjust(int[] arr,int root,int len){
        int left = 2*root + 1;
        int right = 2* root + 2;
        int maxIndex = root;
        if (left<len&& arr[left] >arr[maxIndex]){
            maxIndex = left;
        }
        if (right<len&& arr[right] >arr[maxIndex]){
            maxIndex = right;
        }
        if (maxIndex != root){
            swap(arr,maxIndex,root);
            adjust(arr,maxIndex,len);
        }
    }
    public void countSort(int[] arr){
        int max = arr[0],min = arr[0];
        for (int i = 0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
            if (arr[i]<min){
                min = arr[i];
            }
        }
        int[] list = new int[max-min+1];
        Arrays.fill(list,0);
        for (int i = 0;i<arr.length;i++){
            list[arr[i]-min]++;
        }
        int temp =0;
        for (int i = 0;i<arr.length;i++){
            while (list[temp]==0){
                temp++;
            }
            arr[i] = temp + min;
            list[temp]--;
        }
    }

    public ArrayList<Integer> bucketSort(ArrayList<Integer> arr,int bucketSize){
        if (arr==null || arr.size()<2){
            return arr;
        }
        int max = arr.get(0),min = arr.get(0);
        for (int i = 0;i<arr.size();i++){
            if (arr.get(i)>max){
                max = arr.get(i);
            }
            if (arr.get(i)<min){
                min = arr.get(i);
            }
        }
        int bucketNum = (max-min)/bucketSize+1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i= 0;i<bucketNum;i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0;i<arr.size();i++){
            bucketArr.get((arr.get(i)-min)/bucketSize).add(arr.get(i));
        }
        for (int i = 0;i<bucketNum;i++){
            if (bucketSize ==1){
                for (int j = 0 ;j<bucketArr.get(i).size();j++){
                    result.add(bucketArr.get(i).get(j));
                }
            }
            else{
                if (bucketNum == 1){
                    bucketSize--;
                }
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i),bucketSize);
                for (int j = 0;j<temp.size();j++){
                    result.add(temp.get(j));
                }
            }
        }
        return result;
    }

    public void radixSort(int[] arr){
        int max = arr[0];
        for (int i = 0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        int loop =0;
        while (max>0){
            loop++;
            max/=10;
        }
        int mod = 10;
        int div = 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0;i<mod;i++){
            result.add(new ArrayList<Integer>());
        }
        for (int i = 0;i<loop;i++,mod*=10,div*=10){
            for (int j = 0;j<arr.length;j++){
                result.get(arr[j]%mod/div).add(arr[j]);
            }
            int index = 0;
            for (int j = 0;j<result.size();j++){
                for (int k = 0;k<result.get(j).size();k++){
                    arr[index++] = result.get(j).get(k);
                }
                result.get(j).clear();
            }
        }
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
    }
}
