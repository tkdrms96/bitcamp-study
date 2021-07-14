package hb.day0629;

import java.util.*;

public class work02emp {

  //문제 키보드입력 Scanner클래스, 반복문,  예외처리, 형변환

  public static void main(String[] args)  {
    //java.util팩키지 Scanner생성자3번째(InputSream)
    int sabun;
    String name;
    ArrayList[] pp = new ArrayList[100];
    Scanner sc = new Scanner(System.in);

    for(int i = 0; i<pp.length ; i++) try{
      System.out.print("사번입력>>>");
      sabun=Integer.parseInt(sc.nextLine());
      System.out.print("이름입력>>>");
      name=sc.nextLine();
      if(name.equals("") || name.equals(null)){
        System.out.println("이름데이터를 정확히입력하세요");
        continue;
      }
      System.out.println("사번 = " + sabun);
      System.out.println("이름 = " + name);
    }catch(Exception e) {}
  }

}//class END
