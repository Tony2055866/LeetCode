/**
 * copyright: www.acmerblog.com
 *
 * Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 */
public class FindMinimuminRotatedSortedArrayV2 {

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
            }else {
                high--; // notice the duplicates, it may be {3,3,3,3,3,0,1,2,3}, or {3,0,1,2,3,3,3,3,3}
            }
        }
        return num[low];
    }

    public static void main(String args[]){
        FindMinimuminRotatedSortedArrayV2 f = new FindMinimuminRotatedSortedArrayV2();
        System.out.println(f.findMin(new int[]{3,3,3,3,3,0,1,2,3}));
    }
}
