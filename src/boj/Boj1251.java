package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1251 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    PriorityQueue<String> queue = new PriorityQueue<>();
    for (int i = 1; i < str.length() - 1; i++) {
      String sub1 = str.substring(0, i);
      String temp = str.substring(i);
      for (int j = 1; j < temp.length(); j++) {
        String sub2 = temp.substring(0, j);
        String sub3 = temp.substring(j);

        String reverse1 = new StringBuffer(sub1).reverse().toString();
        String reverse2 = new StringBuffer(sub2).reverse().toString();
        String reverse3 = new StringBuffer(sub3).reverse().toString();
        String result = reverse1 + reverse2 + reverse3;
        queue.offer(result);
      }
    }
    System.out.println(queue.poll());
  }

}
