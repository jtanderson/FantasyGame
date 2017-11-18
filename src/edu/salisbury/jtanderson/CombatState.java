package edu.salisbury.jtanderson;

import java.util.Stack;

public class CombatState extends GameState {
    public CombatState(){
        /**
         * 1. Generate random monster(s)
         */
    }

    // TODO: copy constructor
    public CombatState(CombatState old){

    }

    @Override
    public void handleInput(PlayerEntity pc, String s, Stack<GameState> stack) {
        /**
         * 1. Attack
         *   i.   Make attack
         *   ii.  Enemy retaliates
         *   iii. If monster dies, get random loot/reward
         *   iv.  If player dies, end game
         * 2. Run
         *   i.   Random chance to succeed
         *   ii.  If fail, monster still attacks
         *   iii. If succeed, go to travel state
         */
    }

    @Override
    public void printMenu() {

    }
}
