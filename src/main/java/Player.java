import java.util.Scanner;

public class Player {

  // Properties
  private String name;
  private Scanner s = new Scanner(System.in);

  // Constructors
  public Player(String name) {
    this.name = name;
  }

  // Methods
  public int[] guess() {
    int[] cords = new int[2];
    System.out.println(this.name + " enter your y coordinate");
    cords[0] = s.nextInt();
    System.out.println(this.name + " enter your x coordinate");
    cords[1] = s.nextInt();
    return cords;
  }

  public String getName() {
    return this.name;
  }
}


