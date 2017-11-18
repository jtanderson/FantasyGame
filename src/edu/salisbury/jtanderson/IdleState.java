package edu.salisbury.jtanderson;

import java.util.Stack;

public class IdleState extends GameState {
  public static final int LEAVE_OPTION = 1;
  public static final int STAY_OPTION = 2;

  public void printMenu() {
    System.out.println("You are currently idle.");
    for(int i=0; i < option_str.length; i++) {
      System.out.println((i+1) + ". " + option_str[i]);
    }
  }

  IdleState(){
    option_str = new String[]{
      "Get moving",
        "Stay put"
    };
  }

  @Override
  public void handleInput(String s, Stack<GameState> stack) {
    // TODO Auto-generated method stub
    IdleState is;

    int choice = Integer.parseInt(s);
    switch(choice) {
      case LEAVE_OPTION:
        break;
      case STAY_OPTION:
        is = new IdleState();
        stack.push(is);
        break;
        // TODO: reverse
    }
  }
}
