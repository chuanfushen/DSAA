
import java.util.Arrays;

public class MergeSort {
    public int[] sortArray(int[] nums) {
        if (nums.length<=1){
            return nums;
        }
        int mid = nums.length/2;
        int [] left = sortArray(subArray(nums,0,mid-1));
        int [] right = sortArray(subArray(nums,mid,nums.length-1));
        int [] result = mergeTwoSortedArray(left,right);
        return result;
    }
    public int[] subArray(int[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end + 1);
    }

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
