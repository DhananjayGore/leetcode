/**
 * 
 */
package linear_dp;

/**
 * @author dhananjay 
 * @link  : https://leetcode.com/problems/fibonacci-number/
 * @level : easy
 */
public class LC509_FibonacciNumber {

	int dp[] ;
    public int fib(int n) {
        if( n == 0) return 0;
        if(n == 1) return 1;
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        return getFib(n);
    }
    
    
    public int getFib(int n){
        
        if(n <= 0) return dp[0];
        
        if(n == 1) return dp[1];
        
        if(dp[n] != 0) return dp[n];
        
        dp[n] = getFib(n-1) + getFib(n-2);
        return dp[n];
    }
}
