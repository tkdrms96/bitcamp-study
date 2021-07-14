package hb.day0629;

public class work01jumin {

  public static void main(String[] args) {
    //java.lang패키지 String클래스의 메소드 char chatAt(int) int번째에 있는걸 가져온다
    //java.lang패키지 String클래스의 메소드 int indexOf(int/String) 몇번째있는지 알려줌
    //java.lang패키지 String클래스의 메소드 String substring(1시작,2끝-1) 시작번부터 문자를 가지고옴
    //java.lang패키지 String클래스의 메소드 String substring(1시작) 시작번부터 끝문자까지 문자를 가져옴
    String min = "871024-1541965";
    String min1 = "871024";
    String min2 = "1541965";

    //문제1 총 자릿수 13자릿수, -까지포함해서 14가지
    //문제2 ******-1541965
    //문제3 1/3남자 2/4여자 switch
    //length(), substring(), indexOf()
    int length_ = min1.length() + min2.length(); int minlength = min.length(); //문제1번
    System.out.println(length_); System.out.println(minlength); //문제1번

    String data = min.substring(min.indexOf("-")+1);
    System.out.println("******-"+data); //문제 2번


    char gender = min.charAt(7);
    switch(gender) {
      case '1':
      case '3': System.out.println("남성입니다"); break;
      case '2':
      case '4': System.out.println("여성입니다."); break;
      default : System.out.println("성별이 잘못됐습니다"); break;

    }
  }//end
}//class end
