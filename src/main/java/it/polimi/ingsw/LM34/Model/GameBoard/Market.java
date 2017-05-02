package model.gameboard;

import java.util.ArrayList;

//TODO: apply Singleton design pattern
public class Market {
private ArrayList<ActionSlot> marketSlots;
private final Integer diceValue; //minimum value to place FamilyMembers in the market space
/*private HashMap*/  //TODO: think of a possible use of HashMap here...


public ArrayList<ActionSlot> getActionSlots() {
    return this.marketSlots;
}

//costructor called only at the beginning of the game
//this is a space where configuration are loaded from file, so there must not be variables with hardcoded values...
public Market(ArrayList<ActionSlot> marketSlots, Integer diceValue) {
    this.marketSlots= marketSlots;
    this.diceValue= diceValue;
}
   

}
			