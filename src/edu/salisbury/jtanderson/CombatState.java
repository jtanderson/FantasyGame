package edu.salisbury.jtanderson;

import java.util.Stack;

public class CombatState extends GameState {
    private boolean newEncounter = true;

    public final int ATTACK = 1;
    public final int RETREAT = 2;

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

        int choice = Integer.parseInt(s);
        switch(choice){
            case ATTACK:
                System.out.println("You attack.");
                stack.push(this);
                break;
            case RETREAT:
                System.out.println("You Run.");
                break;
            default:
                System.out.println("Invalid input.");
                stack.push(this);
        }
    }

    @Override
    public void printMenu() {
        //System.out.println("The [creature] prepares to attack!");
        System.out.println("1. Attack");
        System.out.println("2. Run away");
    }

    @Override
    public void enter(){
        if (newEncounter) {
            System.out.println("You enter a hostile [creature!]");
        }
        newEncounter = false;
    }

}
