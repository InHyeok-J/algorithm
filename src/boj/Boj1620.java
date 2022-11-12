package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Boj1620 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> map = new LinkedHashMap<>();
    HashMap<Integer, String> map2 = new LinkedHashMap<>();
    for (int i = 1; i <= N; i++) {
      String str = br.readLine();
      map.put(str, i);
      map2.put(i, str);
    }

    for (int i = 0; i < M; i++) {
      String s = br.readLine();
      char c = s.charAt(0);
      if (Character.isAlphabetic(c)) {
        sb.append(map.get(s)).append("\n");
      } else {
        sb.append(map2.get(Integer.parseInt(s))).append("\n");
      }
    }
    System.out.print(sb);
  }
}
