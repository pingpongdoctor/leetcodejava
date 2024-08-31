// 374. Guess Number Higher or Lower
//Instead of calculating mid with (left+right)/2, we calculate left + (right - left) / 2 to avoid huge number calculation
// public class SearchInRange extends GuessGame {
//   public int guessNumber(int n) {
//       int left = 1;
//       int right = n;
//       while (true){
//           int mid = left + (right - left) / 2;
//           int g = guess(mid);
//           if(g==1){
//               left = mid+1;
//           } else if(g==-1){
//               right = mid-1;
//           } else {
//               return mid;
//           }
//       }
//   }
// }