package sec01_exam;

public class Car {

  String color;
  String gearType;
  int door;


  public Car() {
    this("흰색", "오토", 4);
  }

  public Car(String color) {
    this(color, "오토", 4);
  }
  public Car(String color, String gearType) {
    this(color, gearType, 4);
  }
  public Car(String color, String gearType, int door) {
    this.color = color;
    this.gearType = gearType;
    this.door = door;
  }
  public String getColor() {
    return this.color;
  }
  public String getGearType() {
    return this.gearType;
  }