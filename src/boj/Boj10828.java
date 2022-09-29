package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
*  스택
*/
public class Boj10828 {

  static ArrayList<Integer> stack = new ArrayList<>();

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;
    int N  = Integer.parseInt(br.readLine());

    for(int i = 0 ; i < N ; i++){
      st = new StringTokenizer(br.readLine());
      String type = st.nextToken();
      switch (type){
        case "push":
          int value = Integer.parseInt(st.nextToken());
          push(value);
          break;
        case "top":
          int top = top();
          sb.append(top+"\n");
          break;
        case "size":
          int size = size();
          sb.append(size+"\n");
          break;
        case "empty":
          int empty = empty();
          sb.append(empty+"\n");
          break;
        case "pop":
          int pop = pop();
          sb.append(pop+"\n");
          break;
      }
    }
    System.out.println(sb);
  }

  public static void push(int v){
    stack.add(v);
  }
  public static int pop(){
    if(stack.isEmpty()){
      return -1;
    }else{
      return stack.remove(stack.size()-1);
    }
  }
  public static int size(){
    return stack.size();
  }
  public static int empty(){
    if(stack.isEmpty()){
      return 1;
    }else{
      return 0;
    }
  }
  public static int top(){
    if(stack.isEmpty()){
      return -1;
    }else{
      return stack.get(stack.size()-1);
    }
  }
}
