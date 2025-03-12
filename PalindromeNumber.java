// 9. Palindrome Number
// Extract the last digit (remainder) of the number using modulo operation
// Append the remainder to the reversed number by multiplying the current reverse by 10 and adding the remainder
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<=9 && x>=0){
            return true;
        }
        if(x<0){
            return false;
        }
        int temp = x;
        int reverse = 0;

        while(temp>0){
            int remainder = temp%10;
            reverse = reverse*10 + remainder;
            temp = temp/10;
        }

        return x == reverse;
    }
}
