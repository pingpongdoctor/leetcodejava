import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DetermineifTwoStringsAreClose_1657_Simon {
  private void mergeSort(List<Integer> list, int l, int r){
      if(l<r){
          int m = l + (r-l)/2;
          mergeSort(list,l,m);
          mergeSort(list,m+1,r);
          merge(list,l,m,r);
      }
  }
  private void merge(List<Integer> list, int l, int m , int r){
      List<Integer> list1 = new ArrayList<Integer>(list.subList(l,m+1));
      List<Integer> list2 = new ArrayList<Integer>(list.subList(m+1,r+1));

      int k = 0;
      int j = 0;
      int i = 0;

      while(k<list1.size() && j<list2.size()){
          int val1 = list1.get(k);
          int val2 = list2.get(j);
          if(val1<val2){
              list.set(l+i,val1);
              k++;
          }else{
              list.set(l+i,val2);
              j++;
          }
          i++;
      }

      while(k<list1.size()){
          list.set(l+i,list1.get(k));
          k++;
          i++;
      }
      
      while(j<list2.size()){
          list.set(l+i,list2.get(j));
          j++;
          i++;
      }
  }

  public boolean closeStrings(String word1, String word2) {
      if(word1.length()!=word2.length()){
          return false;
      }
      Map<Character,Integer> map1 = new HashMap<Character,Integer>();
      Map<Character,Integer> map2 = new HashMap<Character,Integer>();
      List<Integer> frequency1 = new ArrayList<Integer>();
      List<Integer> frequency2 = new ArrayList<Integer>();

      for(char s : word1.toCharArray()){
          map1.put(s,map1.getOrDefault(s,0)+1);
      }
      for(char s : word2.toCharArray()){
          map2.put(s,map2.getOrDefault(s,0)+1);
      }
      //check if they have the same set of unique characters
      for(Map.Entry<Character,Integer> entry1:map1.entrySet()){
          if(!map2.containsKey(entry1.getKey())){
              return false;
          }else{
              frequency1.add(entry1.getValue());
          }
      }
      for(Map.Entry<Character,Integer> entry2:map2.entrySet()){
          if(!map1.containsKey(entry2.getKey())){
              return false;
          }else{
              frequency2.add(entry2.getValue());
          }
      }

      //sort two frequency lists
      mergeSort(frequency1,0,frequency1.size()-1);
      mergeSort(frequency2,0,frequency2.size()-1);
      //characters in two words have the same set of frequency if two sorted lists are the same
      for(int i = 0; i<frequency1.size(); i++){   
          System.out.println(frequency1.get(i));
          System.out.println(frequency2.get(i));
          //use equals to compare values of objects
          //ex: 5 is equal to 5 so the result can be true
          //if use ==, the result can be false since they can come from different Integer objects
          if(!frequency1.get(i).equals(frequency2.get(i))){
              return false;
          }
      }

      return true;      
  }
}