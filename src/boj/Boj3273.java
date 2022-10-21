package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj3273 {

  public static void main(String [] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());

    for(int i = 0 ; i < N ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int X = Integer.parseInt(br.readLine());
    int result = 0 ;
    Arrays.sort(arr);
    int start = 0;
    int end = N -1;
    while (start != end){
      int temp = arr[start] + arr[end];
      if(temp > X){
        end--;
      } else if (temp == X) {
        start++;
        result++;
      }else{
        start++;
      }
    }
    System.out.println(result);
  }
}
