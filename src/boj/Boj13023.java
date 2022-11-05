package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj13023 {

  static int N;
  static List<Integer>[] list;
  static boolean[] visited;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    list = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list[a].add(b);
      list[b].add(a);
    }

    for (int i = 0; i < N; i++) {

      visited = new boolean[N];
      DFS(i, 0);

    }
    System.out.println(0);
  }

  public static void DFS(int node, int depth) {
    if (depth == 4) {
      System.out.println(1);
      System.exit(0);
    }
    visited[node] = true;
    List<Integer> integers = list[node];
    for (int i = 0; i < integers.size(); i++) {
      Integer next = integers.get(i);
      if (!visited[next]) {
        DFS(next, depth + 1);
      }
    }
    visited[node] = false;
  }

}
