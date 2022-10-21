package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj9372 {

  static HashMap<Integer, LinkedList<Integer>> tree;
  static StringBuilder sb = new StringBuilder();
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    int K = Integer.parseInt(br.readLine());

    for (int i = 0; i < K; i++) {
      /*
       *  N => 국가 수
       *  M => 비행기 수
       */
      tree = new HashMap<>();

      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      for (int j = 0; j < M; j++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        LinkedList<Integer> orDefault = tree.getOrDefault(a, new LinkedList<>());
        orDefault.add(b);
        LinkedList<Integer> orDefault1 = tree.getOrDefault(b, new LinkedList<>());
        orDefault1.add(a);
        tree.put(a, orDefault);
        tree.put(b, orDefault1);
      }
      sb.append(N - 1);
      sb.append("\n");
    }
    System.out.println(sb);
  }

}
