package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
/*
*  푸는중...
*/
public class Boj1821 {

  static ArrayList<List<Integer>> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    List<Integer> solution = new ArrayList<>();
    int[] arr = new int[N];
    for (int i = 1; i <= N; i++) {
      arr[i - 1] = i;
    }

    perm(arr, new int[N], new boolean[N], 0, N, N);
    for (int i = 0; i < list.size(); i++) {
      List<Integer> search = list.get(i);
      ArrayList<Integer> arrs = new ArrayList<>();
      for (int j = 0; j < search.size() - 1; j++) {
        arrs.add(search.get(j) + search.get(j + 1));
      }

      while (arrs.size() > 1) {
        for (int k = 0; k < arrs.size() - 1; k++) {
          int temp = arrs.get(k) + arrs.get(k + 1);
          arrs.set(k, temp);
        }
        arrs.remove(arrs.size() - 1);
      }
      int result = arrs.get(0);
      if (result == K) {
        solution = search;
        break;
      }
    }

    for (int i : solution) {
      sb.append(i + " ");
    }
    System.out.println(sb);

  }

  static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
    if (depth == r) {
      list.add( Arrays.stream(output).boxed().collect(Collectors.toList()));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        output[depth] = arr[i];
        perm(arr, output, visited, depth + 1, n, r);
        visited[i] = false;
      }
    }
  }
}
