package net.hb.day0628;

/*자바에서 문법적인 에러가 아닌 실행중 에러가 발생시 예외
 * 자바는 생성자 및 메소드에도 예외적용
 * 자바에서 잠시시간지체 Thread클래스.sleep(500매개인자)메소드
 * 임포트 생략 가능합니다 java.lang패키지에 있는 기본클래스 Thread
 * 임포트 생략 가능합니다. java.lang팩키지에있는 기본클래스 Thread
 * java.net.ServerSocket클래스
 * ServerSocket server = new ServerSocket(9900); 예외
 */
public class TestTry {

  public static void main(String[] args) {
    int dan = 3;
    for(int i =1; i <10; i++) {
      System.out.println(dan + "*" +i+"="+(dan*i));
      try{Thread.sleep(1000); } catch(Exception e) {}
    }
    System.out.println();
    System.out.println("우리나라");
    System.out.println("대한민국");
    System.out.println("금수강산");
  }
}