/**
 * Created by GaoTong on 2014/11/11.
 * copyright: www.acmerblog.com
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {

    public boolean inInterleaveRecur(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        if(s1.length() == 0) return s2.equals(s3);
        if(s2.length() == 0) return s1.equals(s3);
        boolean sub1 = false;
        boolean sub2 = false;
        if(s1.charAt(0) == s3.charAt(0))
            sub1 = inInterleaveRecur(s1.substring(1), s2, s3.substring(1));
        if(s2.charAt(0) == s3.charAt(0))
            sub2 = inInterleaveRecur(s1, s2.substring(1), s3.substring(1));
        return sub1 || sub2;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()) return false;

        //dp[i][j]: s1[0...i-1],和s2[0...j-1]可以交错匹配s3的最长长度
        int dp[][] = new int[m+1][n+1];

        dp[0][0] = 0;

        //初始化第一列，即只用s1
        for(int i=1; i<=m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1))
                dp[i][0] = dp[i - 1][0] + 1;
            else break;
        }

        for(int i=1; i<=n; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1))
                dp[0][i] = dp[0][i - 1] + 1;
            else break;
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                    dp[i][j] = dp[i][j-1] + 1;
                if(s1.charAt(i-1) == s3.charAt(i+j-1))
                    dp[i][j] = dp[i-1][j] + 1;
                if(s2.charAt(j-1) == s3.charAt(i+j-1))
                    dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i][j]);
            }
        }

        return dp[m][n] == s3.length();
    }

    public static void main(String args[]){
        InterleavingString ils = new InterleavingString();

        System.out.println(ils.inInterleaveRecur("aabcc","dbbca", "aadbbcbcac"));
        System.out.println(ils.inInterleaveRecur("aabcc", "dbbca", "aadbbbaccc"));

        System.out.println("-----------");

        System.out.println(ils.isInterleave("aabcc","dbbca", "aadbbcbcac"));
        System.out.println(ils.isInterleave("aabcc","dbbca", "aadbbbaccc"));
    }
}
