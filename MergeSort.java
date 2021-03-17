
import java.util.Arrays;

public class MergeSort {
    // To sort an unSortedArray
    public int[] sortArray(int[] nums) {
        if (nums.length<=1){
            return nums;
        }
        int mid = nums.length/2;//find the middle index of nums
        int [] left = sortArray(subArray(nums,0,mid-1)); // separately sort the left array from 0 to mid-1
        int [] right = sortArray(subArray(nums,mid,nums.length-1)); // sort the right part from mid to the last.
        int [] result = mergeTwoSortedArray(left,right); // merge two sorted array,  left and right array are already sorted after Fuction sortArray().
        return result;
    }
    
    // Get the sub-array of array from beg to end. including element of end index.
    public int[] subArray(int[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end + 1);
    }

    // This function is to merge two unsorted array.
    public int[] mergeTwoSortedArray(int[] first,int[] second){
        int index_first = 0;
        int index_second = 0;
        int [] result = new int[first.length+second.length];
        int cnt = 0;
        while(index_first<first.length && index_second<second.length){
            if (first[index_first]<second[index_second]){
                result[cnt] = first[index_first];
                index_first++;
                cnt++;
            }else{
                result[cnt] = second[index_second];
                index_second++;
                cnt++;
            }
        }
        
        //after above while loop, there may leave few element on first or second array. Put them on result array.
        while (index_first < first.length) {
            result[cnt] = first[index_first];
            index_first++;
            cnt++;
        }
        while (index_second < second.length) {
            result[cnt] = second[index_second];
            index_second++;
            cnt++;
        }
        return result;
    }


    public static void main(String[]agrs){
        int[]input= {6,5,3,2,61,213};
        MergeSort merge = new MergeSort();
        System.out.println(Arrays.toString(merge.sortArray(input)));
    }
}
