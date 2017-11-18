# FantasyGame

A demo text-based adventure game primarily to demonstrate advantages of inheritence and polymorphism.
This program is not under active development, and is instead intended as a starting point for programming students to experiment with game development patters.

## Design

1. The game happens in "rounds"
    1. The user is presented with a set of options
    1. The user chooses which option to take
    1. The input is processed and the game state updated
1. A pushdown automata is used to model the state of the game
    1. Instead of only knowing the current state, we track a "stack" of states
    1. At the start of each game loop/round, the top state is popped
    1. Each state is responsible for providing:
        1. The currently available options
        1. Handlign for the each possible choice
    1. In processing the input, the state gets access to
        1. The user input
        1. The player character object
        1. The current stack of states -- so that it can push the next state or more if needed

## Features

Done:
  - [x] GameState pushdown-machine structure
  - [x] TravelingState (keep walking, stop and rest, take forks)
  - [x] Random road forks
  - [x] Cardinal direction tracking
  - [x] Allow handlers to take player entity arg

Todo:
  - [ ] CombatState and actions
  - [ ] More idle actions
  - [ ] Character entities
  - [ ] Simple item/equipment entities
  - [ ] Random text/description generation engine
 
## Helpful Resources
  - [Game Programming Patterns](http://gameprogrammingpatterns.com)
