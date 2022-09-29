package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10818 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[count];

    for(int i =0 ;i <count; i++){
      int temp = Integer.parseInt(st.nextToken());
      arr[i] = temp;
    }

    Arrays.sort(arr);
    System.out.println(arr[0] +" "+arr[count-1]);
  }
}
