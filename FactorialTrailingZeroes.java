// 172. Factorial Trailing Zeroes
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if(n==0 || n==1){
            return 0;
        }
        //number of trailing zero is equevalent to the number of factor 10
        // product 2 and 5 equals to 10 so we can count the factor 2 and factor 5
        // since factor 2 appears more (from every even number) in the factorial
        // the number of trailing zeros equals to the number of factor 5 in the factorial
        // check how many numbers are divisible by the powers of 5
        int ans = 0;
        while(n>0){
            ans += n/5;
            n /= 5;
        }
        return ans;
    }
}
