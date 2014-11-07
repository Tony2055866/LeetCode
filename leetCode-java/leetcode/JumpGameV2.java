/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jumpTle length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameV2 {

    public int jump(int[] A) {
        if(A.length <=1 ) return 0;
        if(A[0] == 0) return Integer.MAX_VALUE;
        int lastEnd = 0; //the max end of the last step
        int minJump = 0; //the steps number
        int nextEnd = A[0]; // the max end of current step's end
        for(int i=1; i<A.length; i++){
            //should be the next step
            if(i > lastEnd){
                minJump++;
                lastEnd = nextEnd;
                nextEnd = 0;
            }
            if(nextEnd < A[i]+i) nextEnd = A[i]+i;
        }
        return minJump;
    }

    // not effiect enough!! TLE
    public int jumpTle(int[] A) {
        int minJumps[] = new int[A.length];
        minJumps[A.length - 1] = 0;
        for(int i=A.length-2; i >= 0; i--){
            //如果可跳至结尾
            if(i + A[i] >= A.length-1){
                minJumps[i] = 1;
                continue;
            }
            int tmpMin = A.length;
            for(int j=i+1; j<=i + A[i]; j++)
                if( tmpMin > minJumps[j]) tmpMin = minJumps[j];
            minJumps[i] = tmpMin+1;
        }
        return minJumps[0];
    }

    public static void main(String args[]){
        JumpGameV2 jumpGameV2 = new JumpGameV2();
        System.out.println(jumpGameV2.jumpTle(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jumpGameV2.jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
    }
}
