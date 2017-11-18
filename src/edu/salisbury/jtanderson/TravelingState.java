package edu.salisbury.jtanderson;

import java.util.ArrayList;
import java.util.Stack;

public class TravelingState extends GameState {
    boolean hasCrossRoad;
    String newRoadDirection;
    String direction;

    public static final int CONTINUE_OPTION = 1;
    public static final int STAY_OPTION = 2;
    public static final int BRANCH_OPTION = 3;

    public void printMenu() {
        System.out.println("You travel down the road heading " + direction + ".");

        if (hasCrossRoad) {
            System.out.println("You come across a fork in the road, headed " + newRoadDirection);
        }

        for(int i=0; i<option_str.length + (hasCrossRoad ? 0 : -1); i++) {
            System.out.println((i+1) + ". " + option_str[i]);
        }
    }

    TravelingState(String dir){
        direction = dir;
        hasCrossRoad = (Math.random() > 0.8);
        if (hasCrossRoad) {
            ArrayList<String> dirs = new ArrayList<String>();
            dirs.add("North");
            dirs.add("South");
            dirs.add("East");
            dirs.add("West");

            dirs.remove(direction);

            int r = (int) (Math.random()*dirs.size());
            newRoadDirection = dirs.get(r);
        }

        option_str = new String[]{
                "Continue walking.",
                "Stay put.",
                "Take the other road."
        };
    }

    @Override
    public void handleInput(PlayerEntity pc, String s, Stack<GameState> stack) {
        TravelingState ts;
        IdleState is;

        int choice = Integer.parseInt(s);
        switch(choice) {
            case CONTINUE_OPTION:
                //System.out.println("You walk " + direction);
                ts = new TravelingState(direction);
                stack.push(ts);
                break;
            case STAY_OPTION:
                System.out.println("You sit down for a rest at the side of the road.");
                stack.push(this);
                is = new IdleState();
                stack.push(is);
                break;
            case BRANCH_OPTION:
                System.out.println("You take the fork in the road."); // + newRoadDirection);
                ts = new TravelingState(newRoadDirection);
                ts.hasCrossRoad = false;
                stack.push(ts);
                break;
            default:
                System.out.println("Invalid selection: " + s);
                stack.push(this);
        }
    }
}
