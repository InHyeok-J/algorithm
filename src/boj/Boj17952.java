package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17952 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int result = 0;
    Stack<List<Integer>> stack = new Stack<>();
    while (N-- > 0) {
      st = new StringTokenizer(br.readLine());

      String type = st.nextToken();

      if (type.equals("1")) {
        Integer A = Integer.parseInt(st.nextToken());
        Integer T = Integer.parseInt(st.nextToken());
        if (T == 1) {
          result += A;
        } else {
          List<Integer> list = new ArrayList<>();
          list.add(0, A);
          ;
          list.add(1, T - 1);
          stack.push(list);
        }
      } else {
        // 0 이면
        if (!stack.isEmpty()) {

          List<Integer> list = stack.pop();
          Integer savedT = list.get(1);
          if (savedT == 1) {
            result += list.get(0);
          } else {
            list.add(1, savedT - 1);
            stack.push(list);
          }
        }
      }
    }
    System.out.println(result);
  }
}
