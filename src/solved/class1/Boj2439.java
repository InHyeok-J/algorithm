package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*  별찍기-2
*/
public class Boj2439 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int count = Integer.parseInt(br.readLine());

    for(int i =1 ; i <=count; i++){
      for(int j = 0; j < count-i ; j++){
        sb.append(" ");
      }

      for(int k = 0; k<i; k++){
        sb.append("*");
      }

      sb.append("\n");
    }
    System.out.println(sb);
  }
}
