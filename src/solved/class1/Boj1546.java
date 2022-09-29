package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
*  평균
*/

public class Boj1546 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    List<Double> scores = new ArrayList<>();
    Double max = 0.0;
    for(int i = 0 ; i < count; i++){
      Double score = Double.parseDouble(st.nextToken());
      scores.add(score);
      if(score >= max){
        max = score;
      }
    }
    Double sum = 0.0;
    for(int i = 0 ; i < scores.size(); i++){
      Double original = scores.get(i);
      Double newScore = (original / max) * 100;
      sum += newScore;
    }
    System.out.println(sum/count);

  }
}
