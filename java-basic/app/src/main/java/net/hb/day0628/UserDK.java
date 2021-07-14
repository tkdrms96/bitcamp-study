package net.hb.day0628;

public class UserDK {
  public static void main(String[] args) {
    //문제 Dunkin클래스 coffee호출 donuts도 호출


    System.out.println("UserDK클래스 3:40");
    Dunkin.donuts(3);
    Dunkin dk = new Dunkin(); //객체를 만들고
    String msg = dk.coffee(); //string msg에 dk값을 저장함
    System.out.println("주문한 음료는" + msg + "입니다");
    // Dunkin.coffee(); non-static 메서드는 그냥사용 불가능 객체를 만들고 사용해야함 



  }
}

