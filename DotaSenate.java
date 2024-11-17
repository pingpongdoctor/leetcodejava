import java.util.LinkedList;
import java.util.Queue;

// 649. Dota Senate
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

    while (senates.size() > 1 && bans.size() <= senates.size()) {
      Character curSenate = senates.poll();
      if (!bans.isEmpty() && bans.peek().equals(curSenate)) {
        bans.poll();
      } else {
        senates.add(curSenate);
        bans.add(curSenate == 'R' ? 'D' : 'R');
      }
    }
    return senates.peek() == 'R' ? "Radiant" : "Dire";
  }

  // optimal solution with radiants and dires queues
  public String predictPartyVictory2(String senate) {
    Queue<Integer> radiants = new LinkedList<>();
    Queue<Integer> dires = new LinkedList<>();
    int n = senate.length();
    if (n == 1) {
      return senate.charAt(0) == 'R' ? "Radiant" : "Dire";
    }

    for (int i = 0; i < n; i++) {
      if (senate.charAt(i) == 'R') {
        radiants.add(i);
      } else {
        dires.add(i);
      }
    }

    while (!radiants.isEmpty() && !dires.isEmpty()) {
      if (radiants.poll() > dires.poll()) {
        dires.add(n);
      } else {
        radiants.add(n);
      }
      n++;
    }

    return radiants.isEmpty() ? "Dire" : "Radiant";
  }
}
