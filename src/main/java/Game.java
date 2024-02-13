public class Game{

  // Properties
  private static final int SIZE      = 3;
  private static final int STATE[][] = new int[SIZE][SIZE]; 
  private Player[] players;

  // Constructors
  public Game(Player x, Player o){
    this.players = new Player[] {x,o};
  }

  // Methods
  public void doTurn(int count){
    int[] cords = this.players[count % players.length].guess();
    STATE[cords[0]][cords[1]] = count % 2 + 1;
    drawBoard();
  }

  public void drawBoard(){
    for(int y = 0; y < SIZE; y++){
      for(int x = 0; x < SIZE;  x++)
        System.out.printf("| " + STATE[y][x] + " |");
      System.out.println();
    } 
  }

  public Player checkWin(){
    int width = STATE[0].length;
    int last = width - 1;
    int first = 0;
    int height = STATE.length - 1;
    int xCord;
    int yCord;

    boolean win = true; 
    int checkNum = STATE[first][last];
    if(checkNum == 0) win = false;
    for(int y = 0; y <= height; y++){
      if(STATE[y][last-y] != checkNum){
        win = false;
      }
    }
    if(win){
      return players[checkNum-1];
    }

    win = true;
    checkNum = STATE[first][first];
    if(checkNum == 0) win = false;
    for(int y = 0; y <= height; y++){
      if(STATE[y][y] != checkNum){
        win = false;
      }
    }
    if(win){
      return players[checkNum-1];
    }

    for(int y = 0; y <= height; y++){
      win = true;
      checkNum = STATE[y][first];
      if(checkNum == 0) win = false;
      for(int x = 0; x <= last; x++){
        if(STATE[y][x] != checkNum){
          win = false;
        }
      }
      if(win){
        return players[checkNum-1];
      }
    }

    for(int x = 0; x <= last; x++){
      win = true;
      checkNum = STATE[first][x];
      if(checkNum == 0) win = false;
      for(int y = 0; y <= height; y++){
        if(STATE[y][x] != checkNum){
          win = false;
        }
      }
      if(win){
        return players[checkNum-1];
      }
    }

    return new Player("NONE");
