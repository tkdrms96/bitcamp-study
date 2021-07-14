package hb.day0629;

public class BitCamp_2 extends LA{

  public static void main(String[] args) {
    BitCamp_2 Book = new BitCamp_2();

    Book.book();
    Book.cherry();
  }//end

  public void book() {
    System.out.println("book 몽블랑");
    this.cherry();
  }//end

  @Override
  public void cherry() {
    System.out.println("stupid 홍찬희 11:48");
  }



}//class END
