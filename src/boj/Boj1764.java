package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj1764 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    SortedMap<String, Integer> map = new TreeMap<>();
    for (int i = 0; i < N; i++) {
      map.put(br.readLine(), 0);
    }
    for (int j = 0; j < M; j++) {
      String str = br.readLine();
      if (map.containsKey(str)) {
        map.put(str, 1);
      }
    }

    int count = 0;
    for (String key : map.keySet()) {
      if (map.get(key) == 1) {
        sb.append(key).append("\n");
        count++;
      }
    }

    System.out.println(count);
    System.out.println(sb);
  }
}
