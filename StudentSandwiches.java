import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class StudentSandwiches {
  public int countStudents(int[] students, int[] sandwiches) {
      Stack<Integer> menu = new Stack<Integer>();
      Queue<Integer> line = new LinkedList<Integer>();

      for(int i = 0; i < students.length; i++){
          menu.push(sandwiches[i]);
          line.add(students[i]);
      }

      int counter = menu.size() * line.size();
      while(counter>0){
          if(line.size()!=0){
              if(line.peek()==menu.peek()){
                  line.remove();
                  menu.pop();
              }else{
                  line.add(line.remove());
              }
              counter--;
          } else {
              break;
          }
      }

      return line.size();

  }
}