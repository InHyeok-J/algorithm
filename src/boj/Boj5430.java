package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj5430 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    while (N-- > 0) {
      String Type = br.readLine();
      int k = Integer.parseInt(br.readLine());
      String str = br.readLine();
      st = new StringTokenizer(str, "[,]");
      Deque<Integer> deque = new LinkedList<>();

      while (st.hasMoreTokens()) {
        int i = Integer.parseInt(st.nextToken());
        deque.offer(i);
      }
      boolean isFront = true;
      boolean isFail = false;
      for (int i = 0; i < Type.length(); i++) {
        String c = Type.substring(i, i + 1);
        if (c.equals("R")) {
          isFront = !isFront;
        } else {
          if (deque.isEmpty()) {
            isFail = true;
            break;
          } else {
            if (isFront) {
              deque.pollFirst();
            } else {
              deque.pollLast();
            }
          }
        }
      }
      if (isFail) {
        sb.append("error").append("\n");
      } else {
        sb.append("[");
        if (deque.isEmpty()) {
          sb.append("]").append("\n");
        } else {
          if (isFront) {
            sb.append(deque.pollFirst());
          } else {
            sb.append(deque.pollLast());
          }
          while (!deque.isEmpty()) {
            if (isFront) {
              Integer integer = deque.pollFirst();
              sb.append(",").append(integer);
            } else {
              Integer integer = deque.pollLast();
              sb.append(",").append(integer);
            }
          }
          sb.append("]").append("\n");
        }
      }
    }
    System.out.println(sb);
  }
}
