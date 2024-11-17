import java.util.LinkedList;
import java.util.Queue;

public class DotaSenate {
  Queue<Character> senates;
  Queue<Character> bans;
  Queue<Character> dires;
  Queue<Character> radiants;

  public DotaSenate() {
    senates = new LinkedList<>();
    bans = new LinkedList<>();
    dires = new LinkedList<>();
    radiants = new LinkedList<>();
  }

  // use bans queue and senates queue
  public String predictPartyVictory(String senate) {
    if (senate.length() == 1) {
      return senate.charAt(0) == 'R' ? "Radiant" : "Dire";
    }

    for (Character c : senate.toCharArray()) {
      senates.add(c);
    }
    int i = 0;
    while (senates.size() > 1 && bans.size() <= senates.size()) {
      Character curSenate = senates.poll();
      if (!bans.isEmpty() && bans.peek().equals(curSenate)) {
        bans.poll();
      } else {
        senates.add(curSenate);
        bans.add(curSenate == 'R' ? 'D' : 'R');
      }
      i++;
    }
    return senates.peek() == 'R' ? "Radiant" : "Dire";
  }

  // optimal solution with radiants and dires queues
}
