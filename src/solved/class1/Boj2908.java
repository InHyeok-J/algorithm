package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2908 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String A = st.nextToken();
    String B = st.nextToken();
    StringBuffer sb1 = new StringBuffer(A);
    StringBuffer sb2 = new StringBuffer(B);

    String reverseA = sb1.reverse().toString();
    String reverseB = sb2.reverse().toString();

    int iA = Integer.parseInt(reverseA);
    int iB = Integer.parseInt(reverseB);

    if(iA>iB){
      System.out.println(reverseA);
    }else{
      System.out.println(reverseB);
    }
  }
}
