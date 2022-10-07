package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9012 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    while (N-- > 0) {
      Stack<Character> stack = new Stack<>();
      String input = br.readLine();
      Boolean isFail = false;
      for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (c == '(') {
          stack.push(c);
        } else {

          if (!stack.isEmpty() && (stack.peek() == '(')) {
            stack.pop();
          } else {
            isFail = true;
            break;
          }
        }
      }

      if(!stack.isEmpty()){
        sb.append("NO").append("\n");
        continue;
      }

      if (isFail) {
        sb.append("NO").append("\n");
      } else {
        sb.append("YES").append("\n");
      }
    }
    System.out.println(sb);
  }
}
