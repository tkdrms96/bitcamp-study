package hb.day0629;

import java.io.*;

public class work03gugudan {

  public static void main(String[] args) {
    try{InputStream is = System.in; //static InputStream(리턴값) . in필드 표준
    //java.util패키지 Scanner 생성자 3번째 ()
    //Scanner sc1 = new Scanner(is);
    //Scanner sc2 = new Scanner(System.in); //표준text

    System.out.print("단입력 > ");
    int dan = is.read();
    for(int a=1; a<10; a++) {
      System.out.println(dan + "*" +a+"="+(dan*a));
    }
    }catch(Exception e){}
  }

}//class end
