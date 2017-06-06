package it.polimi.ingsw.LM34.Model.Effects.ResourceRelatedBonus;

import it.polimi.ingsw.LM34.Controller.AbstractGameContext;
import it.polimi.ingsw.LM34.Model.Effects.AbstractEffect;
import it.polimi.ingsw.LM34.Model.Effects.GameSpaceRelatedBonus.WorkingAreaValueEffect;
import it.polimi.ingsw.LM34.Model.Player;
import it.polimi.ingsw.LM34.Model.Resources;

import java.util.Observable;
import java.util.Observer;

import static it.polimi.ingsw.LM34.Enums.Controller.ContextType.TURN_CONTEXT;

/**
 * Created by GiulioComi on 18/05/2017.
 */


//TODO: remember to activate these rewards in the controller at the beginning of the phase of each player
public class PerRoundLeaderReward extends AbstractEffect implements Observer {
    private Resources resources;
    private Integer councilPrivilege;
    private WorkingAreaValueEffect workingAreaValueEffect; //"francesco sforza, leonardo da vinci"

    public PerRoundLeaderReward(Resources resources, Integer councilPrivilege) {
        /*this.observableContexts = new ArrayList<>();
        this.observableContexts.add(TURN_CONTEXT);*/
        this.resources = resources;
        this.councilPrivilege = councilPrivilege;
    }

    //TODO: "francesco sforza, leonardo da vinci"
    public PerRoundLeaderReward(WorkingAreaValueEffect valueEffect) {
        this.workingAreaValueEffect = valueEffect;
    }

    public PerRoundLeaderReward() {
        resources = null;
        councilPrivilege = null;
        workingAreaValueEffect = null;
    }

    public Resources getResources() {
        return this.resources;
    }

    public Integer getCouncilPrivilege() {
        return this.councilPrivilege;
    }

    public WorkingAreaValueEffect getWorkingAreaValueEffect() {
        return this.workingAreaValueEffect;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Sono PerRoundLeaderReward e sono stato notificato");

          /*  ((ResourceIncomeContext)gameManager.getContextByType(RESOURCE_INCOME_CONTEXT)).handleResources(player, resources);
            player.addCouncilPrivileges(councilPrivilege);
        }*/
    }


    @Override
    public void applyEffect(AbstractGameContext callerContext, Player player) {
        callerContext.getContextByType(TURN_CONTEXT).addObserver(this);

        System.out.println("mi sono iscritto al contesto");
        /*VOID*/


    }


    @Override
    public boolean isOncePerRound() {
        return true; //all these leader bonuses are activable once per round
    }

}