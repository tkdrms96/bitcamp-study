package net.hb.day0628;

public class TestNote {

  public static void main(String[] args) {
    System.out.println("김영임 9:42 ");
    System.out.println("까사노 9:43 ");
    TestNote tn = new TestNote();
    tn.note();
  }//main end

  public String book() { //문제1 같은문서의 메소드호출
    String my = "몽블랑" ; //지역변수=local variable=어린아이=철저하게 보호 
    return my;
  }//end

  public int price() {
    int money = 2700;
    return money;
  }

  public void note() { //Non-static메소드
    String title = book();
    int pay = price();
    System.out.println("책제목=" + title);
    System.out.println("책제목=" + book() );
    System.out.println("책가격=" + pay);
    System.out.println("책가격=" + price());
  }//end

}//class END
