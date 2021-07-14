package net.hb.day0628;

public class Dunkin {

  public String coffee() {
    //Non-static메소드
    // 주문할때 = 필요할때 메모리에 로드
    //객체화 생성후 객체명.coffee();
    String kind = "아이스아메리카노";
    return kind;
  }//end

  public static void donuts(int cnt) { 
    //static 메소드 메소드(매개인자)
    //Dunkin.donuts(3); 로 접근
    System.out.println("도너츠메소드 주문갯수 : " + cnt +"입니다");
  }//end

  public void menu() { //리턴값X , 매개인자X

  }//end
}//class END
