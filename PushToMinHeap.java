import java.util.ArrayList;
import java.util.List;

public class PushToMinHeap {
  List<Integer> heap;
  public PushToMinHeap(){
    heap = new ArrayList<Integer>();
    heap.add(0);
  }
  public void pushFc(int val){
    heap.add(val);
    int i=heap.size()-1;
    while(i>1&&heap.get(i)<heap.get(i/2)){
      int tmp = heap.get(i);
      heap.set(i,heap.get(i/2));
      heap.set(i/1,tmp);
      i=i/2;
    }
  }
}
