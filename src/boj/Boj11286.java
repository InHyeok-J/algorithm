package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj11286 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      //절대값이 작은 순서대로 정렬
      //절대값이 같은 경우 숫자가 작은 순서로
      @Override
      public int compare(Integer o1, Integer o2) {
        if (Math.abs(o2) == Math.abs(o1)) {
          return o1 - o2;
        } else {
          return Math.abs(o1) - Math.abs(o2);
        }
      }
    });
    while (N-- > 0) {
      int K = Integer.parseInt(br.readLine());
      if (K == 0) {
        if(queue.isEmpty()){
          sb.append(0);
        }else{
          sb.append(queue.poll());
        }
        sb.append("\n");
      } else {
        queue.offer(K);
      }
    }
    System.out.println(sb);
  }
}
