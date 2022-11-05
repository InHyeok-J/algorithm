package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj11724 {

  static int N;
  static List<Integer>[] arr;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    arr = new ArrayList[N+1];
    visited = new boolean[N+1];

    for (int i = 0; i <= N; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      arr[A].add(B);
      arr[B].add(A);
    }
    int count = 0;
    for(int i = 1 ; i<= N ; i++ ){
      if(!visited[i]){
        DFS(i);
        count++;
      }
    }
    System.out.println(count);
  }

  public static void DFS(int n) {
    Stack<Integer> stack = new Stack<>();
    stack.push(n);
    visited[n] = true;

    while (!stack.isEmpty()) {
      Integer pop = stack.pop();

      for (int i : arr[pop]) {
        if (!visited[i]) {
          stack.push(i);
          visited[i] = true;
        }
      }
    }
  }
}
