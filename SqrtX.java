// 69. Sqrt(x)
// use binary search to search for mid value
// since there is hard to get the precise mid value because it is a float number, when the loop ends, we can return the rounded R
public class SqrtX {
    public int mySqrt(int x) {
        long L = 1;
        long R = x;
        int result = 0;
        while(L<=R){
            long m = L + (R-L)/2;
            long temp =  (long) m*m;
            if(temp>x){
                R = m-1;
            } else if(temp<=x){
                L = m+1;
                result = (int) m;
            }
        }
        return result;
    }
}
