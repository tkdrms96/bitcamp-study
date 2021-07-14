package net.hb.day0628;

import java.util.*;

/*자바에서 문법적인 에러가 아닌 실행중 에러가 발생시 예외
 * 자바는 생성자 및 메소드에도 예외적용
 * 자바에서 잠시시간지체 Thread클래스.sleep(500매개인자)메소드
 * 임포트 생략 가능합니다 java.lang패키지에 있는 기본클래스 Thread
 * 임포트 생략 가능합니다. java.lang팩키지에있는 기본클래스 Thread
 * java.net.ServerSocket클래스
 * ServerSocket server = new ServerSocket(9900); 예외
 */
public class TestGugudan {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int dan = 1; // 변수에 대한 초기화
    System.out.println("원하는 단을 입력 >>> ");
    try {
      dan = sc.nextInt();
      for(int i =1; i <10; i++) {
        System.out.println(dan + "*" +i+"="+(dan*i));
      }
    }catch(Exception a) {} //try catch 부분이 에러가 나면 제외하고 나머지를 출력하는거
    System.out.println();
    System.out.println("우리나라");
    System.out.println("대한민국");
    System.out.println("금수강산");
    sc.close();
  }
}