package it.polimi.ingsw.LM34.Controller.InteractivePlayerContexts.SpecialContexts;

import it.polimi.ingsw.LM34.Controller.AbstractGameContext;
import it.polimi.ingsw.LM34.Enums.Model.LeaderNames;
import it.polimi.ingsw.LM34.Exceptions.Validation.IncorrectInputException;
import it.polimi.ingsw.LM34.Model.Cards.LeaderCard;
import it.polimi.ingsw.LM34.Model.Player;
import it.polimi.ingsw.LM34.Utils.Validator;

import java.util.ArrayList;
import java.util.List;

import static it.polimi.ingsw.LM34.Enums.Controller.ContextType.LEADER_ACTIVATE_OR_DISCARD_CONTEXT;

/**
 * Created by GiulioComi on 25/05/2017.
 */

/**
 * In this context the player can discard a leader in favor of a privilege or activate his ability
 * In the latter case, all requirements of the leader to activate are verified
 */
public class LeaderActivateOrDiscardContext extends AbstractGameContext {
    private Integer totalLeadersDiscarded;
    private LeaderNames leaderToActivate; //TODO

public LeaderActivateOrDiscardContext() {
    contextType = LEADER_ACTIVATE_OR_DISCARD_CONTEXT;
}

    @Override
    public void interactWithPlayer(Player player) {
        totalLeadersDiscarded = 0; //default value at the start of this context
        /*Activate leader cards*/

        //TODO: check if the player can activate a leader, then register it to the right observer
        /*CopyOtherLeader is activated here*/
        setChanged(); notifyObservers(player);






        /* Discard leader cards*/
        totalLeadersDiscarded = 2;
        System.out.println("carte scartate "+ totalLeadersDiscarded);
        setChanged();
        notifyObservers(totalLeadersDiscarded);

        System.out.println("Ora siamo nel leader discard context con carte scartate "+totalLeadersDiscarded);
        //TODO: handle the player discards and count how many councilPrivileges he deserves (totalleaders = ...)
        //for(Integer i = 0; i<totalLeadersDiscarded; i++)
           // getContextByType(ContextType.USE_COUNCIL_PRIVILEGE_CONTEXT).interactWithPlayer(player);
        //TODO: let the player activate a player, verify if requirements are met
    }

    /**
     * An interactive method that unblocks to the player the ability to clone another leader
     * @param currentPlayer
     */
    /*Called by CopyOtherLeader observer*/
    public void copyOtherLeaderAbility(Player currentPlayer) {
        List<LeaderCard> allLeadersActivatedByOthers = new ArrayList<>();

        //create a list of leaders activated  by other players
        for(Player player : gameManager.getPlayers())
            if(player != currentPlayer) //one player cannot copy an ability of a leader he already has
                allLeadersActivatedByOthers.addAll(player.getActivatedLeadercards());

        Integer leaderToCopy = gameManager.getActivePlayerNetworkController().copyLeaderSelection(allLeadersActivatedByOthers);


        try {
            Validator.checkValidity(leaderToCopy.toString(),allLeadersActivatedByOthers);
            LeaderCard selectedLeader = allLeadersActivatedByOthers.get(leaderToCopy);
            selectedLeader.setIsActivatedByPlayer(); //TODO: evaluate if the card should be stored in the player
            selectedLeader.getBonus().applyEffect(this, currentPlayer);
        }
        /*If input mismatch expected informations... the player is able to try again*/
        catch(IncorrectInputException ide){
            copyOtherLeaderAbility(currentPlayer);
        }
        //TODO: hen let the current player choose which one activate

    }
}