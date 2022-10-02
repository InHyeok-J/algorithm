package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1145 {

  static List<Integer> arrList = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = 5;
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    combi(arr, new boolean[N], 0, N, 3);
    Collections.sort(arrList);
    System.out.println(arrList.get(0));
  }

  public static void combi(int[] arr, boolean[] visited, int depth, int n, int r) {
    if (r == 0) {
      last(arr, visited);
      return;
    }

    if (depth == n) {
      return;
    }
    visited[depth] = true;
    combi(arr, visited, depth + 1, n, r - 1);

    visited[depth] = false;
    combi(arr, visited, depth + 1, n, r);
  }

  public static void last(int[] arr, boolean[] visited) {
    List<Integer> temps = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (visited[i]) {
        temps.add(arr[i]);
      }
    }
    Collections.sort(temps, Collections.reverseOrder());
    int max = temps.remove(0);
    int result = 0;
    int i = 1;
    while (true) {
      result = max * i;
      boolean isMatch = true;
      for (int j = 0; j < temps.size(); j++) {
        if ((result % temps.get(j)) != 0) {
          isMatch = false;
        }
      }
      if (isMatch) {
        break;
      }
      i++;
    }
    arrList.add(result);
  }

}
