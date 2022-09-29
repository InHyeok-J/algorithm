package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
*  제로
*/
public class Boj10773 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();

    int N = Integer.parseInt(br.readLine());

    for(int i = 0 ; i < N ; i++){
      int input = Integer.parseInt(br.readLine());
      if(input == 0){
        stack.pop();
      }else{
        stack.push(input);
      }
    }
    int result = 0;
    while (!stack.isEmpty()){
      Integer value = stack.pop();
      result += value;
    }
    System.out.println(result);
  }
}
