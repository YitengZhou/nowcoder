import java.util.*;

public class Sort {
    public void bubbleSort(int[] arr){
        if (arr.length<2){
            return;
        }
        for (int i =0;i<arr.length-1;i++){
            for (int j = i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }

    public void selectSort(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    public void insertSort(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int preindex = i-1;
            int temp = arr[i];
            while (preindex>=0 && arr[preindex]>temp){
                arr[preindex+1] = arr[preindex];
                preindex--;
            }
            arr[preindex+1] = temp;
        }
    }

    public void shellSort(int[] arr){
        int len = arr.length/2;
        while (len>0){
            for (int i = len;i<arr.length;i++){
                int temp = arr[i];
                int preIndex = i-len;
                while (preIndex>=0 && arr[preIndex]>temp){
                    arr[preIndex+len] = arr[preIndex];
                    preIndex -= len;
                }
                arr[preIndex+len] = temp;
            }
            len/=2;
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
        int l = 0,r=0;
        for (int i =0;i<result.length;i++){
            if(l>=left.length){
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

    public void quickSort(int[] arr, int left,int right){
        while (left>=right){
            return;
        }
        int l = left,r = right;
        int pivot = arr[left];
        while (l!=r){
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
        if (arr == null || arr.length<2){
            return;
        }
        build(arr);
        int len = arr.length-1;
        while (len>=0){
            swap(arr,0,len);
            adapt(arr,0,len);
            len--;
        }
    }

    public void build(int[] arr){
        for (int i = arr.length/2-1;i>=0;i--){
            adapt(arr,i,arr.length);
        }
    }

    public void adapt(int[] arr,int root,int len){
        int maxIndex = root;
        int left = 2*root+1;
        int right = 2*root +2;
        if (left<len && arr[left]>arr[maxIndex]){
            maxIndex = left;
        }
        if (right<len && arr[right] > arr[maxIndex]){
            maxIndex = right;
        }
        if (maxIndex!=root){
            swap(arr,maxIndex,root);
            adapt(arr,maxIndex,len);
        }
    }

    public void countSort(int[] arr){
        if (arr.length<2){
            return;
        }
        int max = arr[0],min = arr[0];
        for (int i = 0;i<arr.length;i++){
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min ){
                min = arr[i];
            }
        }
        int[] result = new int[max-min+1];
        for (int i = 0;i<arr.length;i++){
            result[arr[i]-min]++;
        }
        int r = 0;
        for (int i = 0;i<arr.length;i++){
            while (r<result.length&&result[r]==0){
                r++;
            }
            arr[i] = r+min;
            result[r]--;
        }
    }

    public ArrayList<Integer> bucketSort(ArrayList<Integer> arr, int bucketsize){
        if (arr == null || arr.size()<2){
            return arr;
        }
        int max = arr.get(0),min = arr.get(0);
        for (int i = 0;i<arr.size();i++){
            if (arr.get(i) > max){
                max = arr.get(i);
            }
            if (arr.get(i) < min ){
                min = arr.get(i);
            }
        }
        int bucketNum = (max-min)/bucketsize +1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i =0;i<bucketNum;i++){
            bucketArr.add(new ArrayList<>());
        }
        for (int i = 0;i<arr.size();i++){
            bucketArr.get((arr.get(i)-min)/bucketsize).add(arr.get(i));
        }
        for (int i = 0;i<bucketNum;i++){
            if (bucketsize==1){
                for (int j = 0;j<bucketArr.get(i).size();j++){
                    result.add(bucketArr.get(i).get(j));
                }
            }
            else {
                if (bucketNum==1){
                    bucketsize--;
                }
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i),bucketsize);
                for (int j =0;j<temp.size();j++){
                    result.add(temp.get(j));
                }
            }
        }
        return result;
    }

    public void radixSort(int[] arr){
        if (arr.length<2){
            return;
        }
        int max = arr[0],min = arr[0];
        for (int i = 0;i<arr.length;i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int loop = 0;
        while(max>0){
            max/=10;
            loop++;
        }
        int div =1,mod =10;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for (int i =0;i<10;i++){
            bucketArr.add(new ArrayList<>());
        }
        for (int i =0;i<loop;i++,mod*=10,div*=10){
            for (int j = 0;j<arr.length;j++){
                bucketArr.get(arr[j]%mod/div).add(arr[j]);
            }
            int index = 0;
            for (int j=0;j<10;j++){
                for (int k =0;k<bucketArr.get(j).size();k++){
                    arr[index++] = bucketArr.get(j).get(k);
                }
                bucketArr.get(j).clear();
            }

        }
    }

    public void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] =temp;
    }
}
