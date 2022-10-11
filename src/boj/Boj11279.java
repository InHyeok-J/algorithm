package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj11279 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    while (N--> 0){
      int K = Integer.parseInt(br.readLine());

      if(K == 0){
        if(queue.isEmpty()){
          sb.append(0).append("\n");
        }else{
          sb.append(queue.poll()).append("\n");
        }
      }else{
        queue.offer(K);
      }
    }
    System.out.println(sb);
  }


}
