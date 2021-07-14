package net.hb.day0628;

/*자바에서 문법적인 에러가 아닌 실행중 에러가 발생시 예외
 * 자바는 생성자 및 메소드에도 예외적용
 * 자바에서 잠시시간지체 Thread클래스.sleep(500매개인자)메소드
 * 임포트 생략 가능합니다 java.lang패키지에 있는 기본클래스 Thread
 * 임포트 생략 가능합니다. java.lang팩키지에있는 기본클래스 Thread
 * java.net.ServerSocket클래스
 * ServerSocket server = new ServerSocket(9900); 예외
 */
public class TestException2 {

  public static void main(String[] args) {
    int su1 = 9;
    int su2 = 5;
    int mul=0, mok=0;

    mul = su1*su2 ;
    mok = su1/su2 ; // 실행중에 에러가 발생
    System.out.println(su1+" * " + su2 + "=" + mul);
    System.out.println(su1+" / " + su2 + "=" + mul);

    //    boolean[] camp = new boolean[5];
    //    System.out.println(camp[11]);
    //    System.out.println(camp[4]); 

    System.out.println("\n***** 까사노의 1학기 점수 *****");
    System.out.println("국어=90");
    System.out.println("영어=85");
    System.out.println("총점=175");
  }
}