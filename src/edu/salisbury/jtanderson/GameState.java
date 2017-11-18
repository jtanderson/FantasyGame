package edu.salisbury.jtanderson;

import java.util.Stack;

public abstract class GameState {
	//public WorldLocation location; // To keep track of specific locations

    /**
     * Runs every loop, printing the options available
     */
	public abstract void printMenu();

    /**
     * Runs after user menu is printed. Gets access to state stack and the PC object
     *
     * @param pc
     * @param s
     * @param stack
     */
	public abstract void handleInput(PlayerEntity pc, String s, Stack<GameState> stack);
	
	public int[] options = {};
	public String[] option_str = {};
	
	double combatProbability = 0.1;

	// To be run for any initial UI/setup
	public void enter(){}

	// To be run once the state is done for UI/cleanup
    public void exit(){}
}
