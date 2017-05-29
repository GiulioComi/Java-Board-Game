package it.polimi.ingsw.LM34.Model.Effects;

import it.polimi.ingsw.LM34.Controller.AbstractGameContext;
import it.polimi.ingsw.LM34.Controller.SpecialContexts.TurnContext;
import it.polimi.ingsw.LM34.Model.Player;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by vladc on 5/14/2017.
 */


public class SkipFirstTurn extends AbstractEffect implements Observer {
    private Boolean skipFirstTurn;
    ArrayList<AbstractGameContext> contexts;

    public SkipFirstTurn(Boolean skipFirstTurn) {
        this.skipFirstTurn = skipFirstTurn;
    }

    public Boolean hasToSkipFirstTurn() {
        return this.skipFirstTurn;
    }


    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof TurnContext) {
            TurnContext turnContext = (TurnContext) arg;
            //TODO: Make the player skip his turn
            turnContext.deleteObserver(this);
        }

        /**
         * Unregister this observer because it is applicable once per round; it will be reactivated next round in the phase context
         */
        //Utilities.getContextByType(contexts, ContextType.TURN_CONTEXT).deleteObserver(this);
    }

    @Override
    public void subscribeObserverToContext(ArrayList<AbstractGameContext> contexts)  {
        //Utilities.getContextByType(contexts, ContextType.TURN_CONTEXT).addObserver(this);
    }



    @Override
    public void applyEffect(Player player) {

    }


    @Override
    public boolean isOncePerRound() {
        return true;
    }
}