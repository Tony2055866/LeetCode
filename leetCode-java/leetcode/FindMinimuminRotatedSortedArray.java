/**
 * Created by admin on 2014/11/8.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] num) {
        int low = 0;
        int high = num.length-1;
        while(low < high){
            //if it's already sorted, just returned the first one
            if(num[low] < num[high] ) return num[low];
            int mid = (low+high)/2;
            if(num[mid] > num[high]){
                low = mid+1;
            }else if(num[mid] < num[high]) {
                high = mid; // notice
            }
        }
        return num[low];
    }

    public static void main(String args[]){
        FindMinimuminRotatedSortedArray f = new FindMinimuminRotatedSortedArray();
        System.out.println(f.findMin(new int[]{4, 5, 6 ,7 ,0 ,1 ,2}));
    }
}
