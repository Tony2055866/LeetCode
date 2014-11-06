/**
 * Created by admin on 2014/11/5.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if(A.length <= 1) return true;
        boolean jump = false;
        int maxLen = 0;
        for(int i=A.length-2; i>=0; i--){
            if(A[i] > maxLen){
                maxLen = 0;
                jump = true;
            }else{
                maxLen++;
                jump = false;
            }
        }
        return jump;
    }

    public static void main(String args[]){
        JumpGame jumpGame = new JumpGame();
        int a[] = new int[]{2,3,1,1,4};
        System.out.println(jumpGame.canJump(a));
    }
}
