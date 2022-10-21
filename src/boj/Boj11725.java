package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj11725 {

  static HashMap<String, LinkedList<String>> tree = new HashMap<>();
  static int[] result;
  static StringBuilder sb = new StringBuilder();
  ;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    result = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      tree.put(String.valueOf(i), new LinkedList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      String X = st.nextToken();
      String Y = st.nextToken();
      tree.get(X).add(Y);
      tree.get(Y).add(X);
    }
    BFS();

    for (int i = 2; i < result.length; i++) {
      sb.append(result[i]).append("\n");
    }
    System.out.println(sb);
  }

  public static void BFS() {
    Set<String> visited = new HashSet<>();
    Queue<String> needVisited = new LinkedList<>();
    needVisited.offer("1");
    while (!needVisited.isEmpty()) {
      String node = needVisited.poll();
      if (!visited.contains(node)) {
        visited.add(node);
        LinkedList<String> list = tree.get(node);
        for (String str : list) {
          tree.get(str).remove(node);
          result[Integer.parseInt(str)] = Integer.parseInt(node);
          needVisited.offer(str);
        }
      }
    }

  }

}
