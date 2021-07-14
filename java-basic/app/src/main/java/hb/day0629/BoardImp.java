package hb.day0629;

public interface BoardImp { 
  // abstract = 추상메소드 = 명세서 = 이런게있을거야????
  public abstract int boardCount();
  public abstract boolean boardInsert();
  public void boardDelete(int num);

} //interface END

//interface 상속 => 다중상속을 명시할수있음  