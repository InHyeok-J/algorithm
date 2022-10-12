package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj10845 {

  static Deque<Integer> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      st = new StringTokenizer(br.readLine());
      String type = st.nextToken();
      switch (type) {
        case "push":
          int i = Integer.parseInt(st.nextToken());
          queue.offer(i);
          break;
        case "pop":
          if (queue.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            sb.append(queue.poll()).append("\n");
          }
          break;
        case "size":
          sb.append(queue.size()).append("\n");
          break;
        case "empty":
          if (queue.isEmpty()) {
            sb.append(1).append("\n");
          } else {
            sb.append(0).append("\n");
          }
          break;
        case "front":
          if (queue.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            sb.append(queue.peekFirst()).append("\n");
          }
          break;
        case "back":
          if (queue.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            sb.append(queue.peekLast()).append("\n");
          }
      }
    }
    System.out.println(sb);

  }
}
