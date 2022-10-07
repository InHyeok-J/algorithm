package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1874 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    int getCount = 0;
    int i = 1;
    int max = N;
    while (max-- > 0) {
      int n = Integer.parseInt(br.readLine());

      if (i <= n) {
        while (i <= n) {
          stack.push(i++);
          sb.append("+").append("\n");
        }
      }

      if (stack.peek() == n) {
        stack.pop();
        sb.append("-").append("\n");
        getCount++;
      }
    }
    if (getCount == N) {
      System.out.println(sb);
    } else {
      System.out.println("NO");
    }
  }
}
