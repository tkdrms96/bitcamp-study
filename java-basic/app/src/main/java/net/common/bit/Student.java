package net.common.bit;

public class Student {

  private String name;
  private String no;




  public String getName() {
    return name;
  }
  public Student(String name, String no) {
    super();
    this.name = name;
    this.no = no;
  }


  public void setName(String name) {
    this.name = name;
  }
  public String getNo() {
    return no;
  }
  public void setNo(String no) {
    this.no = no;
  }
}
