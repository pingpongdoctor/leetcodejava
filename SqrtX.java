public class SqrtX {
    public int mySqrt(int x) {
        float L = 1;
        float R = x;

        while(L<=R){
            float m = L + (R-L)/2;
            float temp = m*m;
            if(temp>x){
                R = m-1;
            } else if(temp<x){
                L = m+1;
            } else {
                return (int) Math.floor(m);
            }
        }
        return (int) Math.round(R);
    }
}
