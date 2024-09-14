import java.util.ArrayList;
import java.util.List;

public class PopMinValueFromMinHeap {
  List<Integer> heap;

  public PopMinValueFromMinHeap(){
    heap = new ArrayList<Integer>();
    heap.add(0);
  }

  public void pop(){
    //check if heap is empty
    if(heap.size()==1){
      return;
    }
    //check if heap has only one root node
    if(heap.size()==2){
      heap.remove(1);
      return;
    }

    //remove the right most node in the last level and replace the root node by the deleted node
    heap.add(1,heap.remove(heap.size()-1));

    int i = 1;
    //percolate down until reach the leaf node or find the right place for the right most node in the last level
    while(i*2<heap.size()){
      //if right node is available and right node value is smaller than left and current node values
      if(i*2+1<heap.size()&&heap.get(i*2+1)<heap.get(i)&&heap.get(i*2+1)<heap.get(i*2)){
        //swap current node with the right node
        int tmp = heap.get(i);
        heap.set(i,heap.get(i*2+1));
        heap.set(i*2+1,tmp);
        i=i*2+1;
      }
      //if right node is not there and left node is less than current node, swap current node with left node
      else if(heap.get(i)>heap.get(i*2))
      {
        int tmp = heap.get(i);
        heap.set(i, heap.get(i*2));
        heap.set(i*2, tmp);
        i=i*2;
      }else{
        //if no above cases are executed, the added node is now at its right place
        break;
      }
    }
  }
}
