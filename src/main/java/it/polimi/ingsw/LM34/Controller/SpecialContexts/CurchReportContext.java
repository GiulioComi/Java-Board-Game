package it.polimi.ingsw.LM34.Controller.SpecialContexts;

import it.polimi.ingsw.LM34.Controller.AbstractGameContext;
import it.polimi.ingsw.LM34.Controller.SupportContexts.ResourceIncomeContext;
import it.polimi.ingsw.LM34.Enums.Controller.ContextType;
import it.polimi.ingsw.LM34.Model.Cards.ExcommunicationCard;
import it.polimi.ingsw.LM34.Model.Player;
import it.polimi.ingsw.LM34.Model.Resources;

import java.util.ArrayList;

import static it.polimi.ingsw.LM34.Enums.Controller.ContextType.RESOURCE_INCOME_CONTEXT;
import static it.polimi.ingsw.LM34.Enums.Model.ResourceType.FAITH_POINTS;

/**
 * Created by GiulioComi on 16/05/2017.
 */
public class CurchReportContext  extends AbstractGameContext {
    private ArrayList<ExcommunicationCard> excommunicationCards; //added by the GameManager at game startup



    public CurchReportContext() {
        excommunicationCards = new ArrayList<>();
    }


    @Override
    public void interactWithPlayer(Player player) {
        //let the player choice if they wants to be excommunicated and assigned the negative effect to them
        checkEnoughFaithPoints(player, player.getResources().getResourceByType(FAITH_POINTS));


        setChanged(); notifyObservers(player);  /*trigger sisto IV if is an observer*/


        //TODO: addVcitoryPointsFromFaithPath based on faith track position
        Integer faithReward = player.getResources().getResourceByType(FAITH_POINTS);

        Resources reward = new Resources(0,faithReward,0);  /*Wrapper*/
        ((ResourceIncomeContext) gameManager.getContextByType(RESOURCE_INCOME_CONTEXT)).handleResources(player, reward);


    }

    /**
     *
     * @param resourceByType
     */
    private void checkEnoughFaithPoints(Player player, Integer faithPoints) {
        //TODO: faith points necessary depends on the # of period
        //if(faithPoints < Configurator.MIN_FAITHS_POINTS[GameManager.getPeriod()])
            //excommunicationCards.get(GameManager.getPeriod()).getPenalty().applyEffect(player);
    }

    @Override
    public ContextType getType() {
        return ContextType.CURCH_REPORT_CONTEXT;
    }

    /**
     * @param card choosed at game startup as a penalty card (1 per period)
     */
    public void addExcommunicationCard(ExcommunicationCard card) {
        excommunicationCards.add(card);
    }
}


