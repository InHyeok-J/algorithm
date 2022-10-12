package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1284 {

  public static void main(String [] args )throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true){
      String s = br.readLine();
      if(s.equals("0")) break;
      int result = 1;
      for(int i = 0 ; i < s.length(); i++){
        char c = s.charAt(i);
        if(c == '1'){
          result+=3;
        }else if (c == '0'){
          result+=5;
        }else{
          result+=4;
        }
      }
      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }
}
