package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
*  문자열 반복
*/
public class Boj2675 {


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int inputCount = Integer.parseInt(br.readLine());


    for(int i = 0; i < inputCount; i++){
      st= new StringTokenizer(br.readLine());
      int count = Integer.parseInt(st.nextToken());
      String str = st.nextToken();

      for(int j = 0; j < str.length(); j++){
        for(int k = 0 ; k < count; k++){
          sb.append(str.charAt(j));
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
