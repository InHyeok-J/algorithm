package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj8958 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int inputCount = Integer.parseInt(br.readLine());

    for(int i = 0 ; i < inputCount; i++){
      String a = br.readLine();

      int score = 1;
      int scoreResult = 0;
      for(int k = 0; k < a.length(); k++){
        char oX = a.charAt(k);
        if(oX == 'O'){
          scoreResult+=score;
          score++;
        }else{
          score = 1;
        }
      }
      sb.append(scoreResult+"\n");
    }

    System.out.println(sb);
  }
}
