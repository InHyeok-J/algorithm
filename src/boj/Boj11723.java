package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj11723 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    while (N-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String op = st.nextToken();
      switch (op) {
        case "add":
          int v = Integer.parseInt(st.nextToken());
          add(v);
          break;
        case "check":
          int check = check(Integer.parseInt(st.nextToken()));
          sb.append(check).append("\n");
          break;
        case "remove":
          remove(Integer.parseInt(st.nextToken()));
          break;
        case "toggle":
          toggle(Integer.parseInt(st.nextToken()));
          break;
        case "all":
          all();
          break;
        case "empty":
          empty();
          break;
      }
    }
    System.out.println(sb);
  }

  static Set<Integer> set = new HashSet<>();

  static void add(int a) {
    set.add(a);
  }

  static void remove(int a) {
    set.remove(a);
  }

  static int check(int a) {
    if (set.contains(a)) {
      return 1;
    }
    return 0;
  }

  static void toggle(int a) {
    if (set.contains(a)) {
      set.remove(a);
    } else {
      set.add(a);
    }
  }

  static void all() {
    for (int i = 1; i <= 20; i++) {
      set.add(i);
    }
  }

  static void empty() {
    set.clear();
  }
}
