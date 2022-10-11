package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1655 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int N = Integer.parseInt(br.readLine());

    while (N-- > 0) {
      int K = Integer.parseInt(br.readLine());
      if (max.size() == min.size()) {
        max.offer(K);
      }else{
        min.offer(K);
      }

      if (!min.isEmpty() && !max.isEmpty() && min.peek() <= max.peek()) {
        Integer temp = min.poll();
        min.offer(max.poll());
        max.offer(temp);
      }
      sb.append(max.peek()).append("\n");
    }
    System.out.println(sb);
  }

}
