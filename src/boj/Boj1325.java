package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1325 {
  static ArrayList<Integer>[] tree;
  static int[] result;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    tree = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }
    result = new int[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      // a -> b를 신뢰함 => b를 해킹하면 a를 해킹 가능.
      tree[a].add(b);
    }
    int max = 0;

    for (int i = 1; i <= N; i++) {
      visited = new boolean[N + 1];
      BFS(i);
    }

    for (int i : result) {
      if (i >= max) {
        max = i;
      }
    }

    for (int i = 1; i <= N; i++) {
      if (result[i] == max) {
        sb.append(i + " ");
      }
    }

    System.out.println(sb);
  }


  public static void BFS(int startNode) {
    Queue<Integer> needVisited = new LinkedList<>();
    needVisited.offer(startNode);
    result[startNode]++;
    visited[startNode] = true;
    while (!needVisited.isEmpty()) {
      Integer node = needVisited.poll();
      ArrayList<Integer> list = tree[node];
      for (int num : list) {
        if (!visited[num]) {
          needVisited.offer(num);
          result[num]++;
          visited[num] = true;
        }
      }
    }
  }

//  public static void DFS(int startNode) {
//    Stack<Integer> needVisited = new Stack<>();
//    needVisited.push(startNode);
//    result[startNode]++;
//    int roopcount = 0;
//    while (!needVisited.isEmpty()) {
//      Integer pop = needVisited.pop();
//      visited[pop] = true;
//      roopcount++;
//      for (Integer integer : tree[pop]) {
//        if (!visited[integer]) {
//          needVisited.push(integer);
//          result[integer]++;
//        }
//      }
//    }
//    System.out.println("루프 = " + roopcount);
//    for (int i : result){
//      System.out.print(i+ " ");
//    }
//    System.out.println();
//  }
}
