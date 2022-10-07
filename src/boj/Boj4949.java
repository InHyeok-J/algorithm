package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj4949 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      String input = br.readLine();
      if (input.equals(".")) {
        break;
      }
      Stack<Character> stackA = new Stack<>();
      Boolean isFail = false;
      for (int i = 0; i < input.length() - 1; i++) {
        char c = input.charAt(i);

        if (c == '(') {
          stackA.push(c);
        } else if (c == '[') {
          stackA.push(c);
        } else if (c == ')') {
          if(!stackA.isEmpty() && stackA.peek() == '('){
            stackA.pop();
          }else{
            isFail= true;
            break;
          }
        }else if( c == ']'){
          if(!stackA.isEmpty() && stackA.peek() == '['){
            stackA.pop();
          }else{
            isFail = true;
            break;
          }
        }
      }

      if(isFail){
        sb.append("no").append("\n");
        continue;
      }
      if(stackA.isEmpty()){
        sb.append("yes").append("\n");
      }else{
        sb.append("no").append("\n");
      }
    }
    System.out.println(sb);
  }
}
