package net.hb.day0628;

public class SJUser {
  public static void main(String[] args) {
    SJ sj = new SJ();

    String name = "길동";
    int su = 90;
    int second = 60;
    int hap = sj.getTotal(name, su, second);
    double avg = sj.getMean(hap);
    char grade = sj.getGrade(avg);
    String retake = sj.result(avg,su,second);

    System.out.println("합계 =" + hap);
    System.out.println("합계 =" + avg);
    System.out.println("합계 =" + grade);
    System.out.println(retake);
  }
}
