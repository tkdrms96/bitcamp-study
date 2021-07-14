package hb.day0629;

public class BitCamp_3{

  public BitCamp_3() {}
  public BitCamp_3(String location) {}
  public BitCamp_3(int floor) {}
  public BitCamp_3(String location, int floor, String abc) {}

  public static void main(String[] args) {
    BitCamp_3 bc = new BitCamp_3();

    bc.coffee();
  }

  public void coffee() {
    System.out.println("coffee 아메리카노");
    this.cookie();
  }//end


  public void cookie() {
    System.out.println("cookie 바삭바삭");
  }



}
