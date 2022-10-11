package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1927 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    while (N-->0){
      int K = Integer.parseInt(br.readLine());

      if(K == 0){
        if(priorityQueue.isEmpty()){
          sb.append(0);
        }else{
          sb.append(priorityQueue.poll());
        }
        sb.append("\n");
      }else{
        priorityQueue.offer(K);
      }
    }
    System.out.println(sb);
  }
}
