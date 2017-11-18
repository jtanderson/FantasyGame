package edu.salisbury.jtanderson;

import java.util.Stack;

public abstract class GameState {
	//public WorldLocation location;
	public abstract void printMenu();
	public abstract void handleInput(PlayerEntity pc, String s, Stack<GameState> stack);
	
	public int[] options = {};
	public String[] option_str = {};
	
	double combatProbability = 0.1;
	
	public GameState(){}
}
