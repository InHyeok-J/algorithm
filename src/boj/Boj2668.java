package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Boj2668 {

  static int N;
  static int[] map1;
  static int[] map2;

  static boolean[] TopVisit;
  static List<Integer> DownVisit = new LinkedList<>();
  static List<Integer> result = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    map1 = new int[N + 1];
    map2 = new int[N + 1];
    TopVisit = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      map1[i] = i;
    }
    for (int i = 1; i <= N; i++) {
      map2[i] = Integer.parseInt(br.readLine());
    }

    DFS();

  }

  public static void DFS() {
    List<Integer> answer = new ArrayList<>();
    for (int i = 1; i <= N; i++) {

      Stack<Integer> stack = new Stack<>();
      stack.push(i);
      TopVisit[i] = true;
      System.out.println("---- " + i);
      while (!stack.isEmpty()) {
        Integer pop = stack.pop();
        System.out.println(pop);
        int next = map2[pop];
        DownVisit.add(next);
        if (!TopVisit[next]) {
          stack.push(next);
          TopVisit[next] = true;
        } else {
          if (compare()) {
            System.out.println("OK??");
            List<Integer> ok = getOk();
            answer.addAll(ok);
          } else {
            TopVisit[pop] = false;
          }
        }
      }
    }
    System.out.println(answer.size());
  }

  public static List<Integer> getOk() {
    List<Integer> answer = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      if (TopVisit[i]) {
        answer.add(i);
      }
    }
    return answer;
  }

  public static boolean compare() {
    for (int i = 1; i <= N; i++) {
      if (TopVisit[i] && !DownVisit.contains(i)) {
        return false;
      }
    }
    return true;
  }
}
