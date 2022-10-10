package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2164 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Queue<Integer> queue = new LinkedList<>();

    for(int i = 1 ; i <= N; i++){
      queue.offer(i);
    }

    while (queue.size() != 1){
      //1장 버리기
      queue.poll();

      Integer poll = queue.poll();
      queue.offer(poll);
    }

    System.out.println(queue.peek());
  }
}
