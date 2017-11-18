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

      // Random combat encounter , push old one back for when combat is done
      if(Math.random() > (1-currentState.combatProbability)){
        stateStack.push(currentState);
        CombatState cs = new CombatState();
        currentState = cs;
      }

      currentState.enter(); // Set up the scene if necessary

      currentState.printMenu(); // Print the current options to the user

      currentState.handleInput(player, input.nextLine(), stateStack); // Run game logic based on choice

      currentState.exit(); // Teardown
    }
  }
}
