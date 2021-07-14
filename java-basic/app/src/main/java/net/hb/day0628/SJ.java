package net.hb.day0628;

public class SJ {

  public int getTotal(String name, int kor, int eng) {
    System.out.println(name + "님의 성적합계처리");
    int hap = kor + eng;
    return hap;
  }

  public double getMean(int value) {
    System.out.println("님의 평균 점수");
    double dd = value/2;
    return dd;
  }

  public char getGrade(double date) {
    char grade = 'F';
    switch((int)date/10){
      case 10:
      case 9: grade='A'; break;
      case 8: grade='B'; break;
      case 7: grade='C'; break;
      case 6: grade='D'; break;
      default : grade = 'F'; break;
    }
    return grade;
  }
  public String result(double average, int eng, int kor) {
    String msg = "합격여부 안내문";
    if(average >= 70 && kor >= 60 && eng >= 60) { 
      msg = "축 합격";
    }else {
      msg = "불합격";
    }
    return msg;
  }


}//class END
//합계구하는 함수 hap~~ sum~~ total~~ getXXX( )
//평균구하는 함수 avg~~~ average~~~ mean~~~ setXXX( )
//학점구하는 함수 grade~~~ hajum~~~
//합격여부를 구하는 함수 pass~~~ success~~~
