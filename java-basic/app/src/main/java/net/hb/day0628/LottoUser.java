package net.hb.day0628;

public class LottoUser {

  public static void main(String[] args) {
    Lotto LG = new Lotto();

    int[] ret = LG.input(); //출력의 목적이 없음 
    Lotto.output(ret);

    int value = LG.inputHap();  //리턴값을 안받으면 그냥 호출, 에러는 없지만 의미가 없음 
    System.out.println("숫자합계=" + value);
    System.out.println("숫자합계=" + LG.inputHap());

    System.out.println();
    System.out.println("LottoUser 10:08 11:00 ");
  }//end
}//class END

/* 빈번하게 자주 참고하는애들 자동으로 참고하는 애들은 static으로 처리 (ex 정수기 , 자동문 등 ) 

 */