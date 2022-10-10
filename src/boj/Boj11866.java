package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11866 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    sb.append("<");
    int N = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      queue.offer(i);
    }

    while (!queue.isEmpty()) {
      for (int i = 0; i < k - 1; i++) {
        Integer poll = queue.poll();
        queue.offer(poll);
      }

      Integer poll = queue.poll();
      if (queue.size() == 0) {
        sb.append(poll);
      } else {
        sb.append(poll + ", ");
      }
    }
    sb.append(">");
    System.out.println(sb);
  }
}
