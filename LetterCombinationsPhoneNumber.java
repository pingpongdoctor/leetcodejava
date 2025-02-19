import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 17. Letter Combinations of a Phone Number with DFS and Backtracking solution
public class LetterCombinationsPhoneNumber {
  private void backtracking(Map<Character,String> map, List<String> ans, String digits, int idx, StringBuilder temp){
    String newString = temp.toString();

    if(idx==digits.length()){
        ans.add(newString);
        return;
    }

    String cur = map.get(digits.charAt(idx));
    for(char c : cur.toCharArray()){
        temp.append(c);
        backtracking(map,ans,digits,idx+1,temp);
        temp.deleteCharAt(temp.length()-1);
    }
}
public List<String> letterCombinations(String digits) {
    List<String> ans = new ArrayList<>();
    if(digits.length()==0){
        return ans;
    }
    Map<Character,String> map = new HashMap<>();
    map.put('2',"abc");
    map.put('3',"def"); 
    map.put('4',"ghi"); 
    map.put('5',"jkl"); 
    map.put('6',"mno");
    map.put('7',"pqrs"); 
    map.put('8',"tuv"); 
    map.put('9',"wxyz");
    backtracking(map,ans,digits,0, new StringBuilder());
    return ans;
}
}