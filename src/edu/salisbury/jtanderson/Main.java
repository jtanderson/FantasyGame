package edu.salisbury.jtanderson;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static GameState currentState;
  public static Scanner input = new Scanner(System.in);
  public static Stack<GameState> stateStack;
  public static PlayerEntity player;

  public static void main(String[] args) {

    stateStack = new Stack<GameState>();
    player = new PlayerEntity();

    TravelingState s = new TravelingState("North"); // Start on a road north
    stateStack.push(s);

    while(!stateStack.isEmpty()) {
      currentState = stateStack.pop();
      // TODO: Random combat, push old one back down for when combat is done

      currentState.printMenu();
      currentState.handleInput(player, input.nextLine(), stateStack);
    }
  }
}
