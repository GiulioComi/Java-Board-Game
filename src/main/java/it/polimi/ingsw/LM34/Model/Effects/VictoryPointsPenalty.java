package it.polimi.ingsw.LM34.Model.Effects;

import it.polimi.ingsw.LM34.Enums.DevelopmentCardColor;
import it.polimi.ingsw.LM34.Model.Resources;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by vladc on 5/13/2017.
 */
// handles third period excomunication tiles
public class VictoryPointsPenalty extends AbstractEffect implements Observer {
    private Integer victoryPoints;
    private Resources resources;
    private Integer playerGoods;
    private Integer buildingCardsWoods;
    private Integer buildingCardsStones;
    private DevelopmentCardColor cardColor;

    public VictoryPointsPenalty(Integer victoryPoints, Resources resources) {
        this.victoryPoints = victoryPoints;
        this.resources = resources;
        this.playerGoods = 0;
        this.buildingCardsWoods = 0;
        this.buildingCardsStones = 0;
        this.cardColor = null;

    }

    public VictoryPointsPenalty(Integer victoryPoints, Integer playerGoods) {
        this.victoryPoints = victoryPoints;
        this.resources = null;
        this.playerGoods = playerGoods;
        this.buildingCardsWoods = 0;
        this.buildingCardsStones = 0;
        this.cardColor = null;
    }

    public VictoryPointsPenalty(Integer victoryPoints, Integer buildingCardsWoods, Integer buildingCardsStones) {
        this.victoryPoints = victoryPoints;
        this.resources = null;
        this.playerGoods = 0;
        this.buildingCardsWoods = buildingCardsWoods;
        this.buildingCardsStones = buildingCardsStones;
        this.cardColor = null;
    }

    public VictoryPointsPenalty(DevelopmentCardColor cardColor) {
        this.victoryPoints = null;
        this.resources = null;
        this.playerGoods = 0;
        this.buildingCardsWoods = 0;
        this.buildingCardsStones = 0;
        this.cardColor = cardColor;
    }

    public Integer getVictoryPoints() {
        return this.victoryPoints;
    }

    public Resources getResources() {
        return this.resources;
    }

    public Integer getPlayerGoods() {
        return this.playerGoods;
    }

    public Integer getBuildingCardsWoods() {
        return this.buildingCardsWoods;
    }

    public Integer getBuildingCardsStones() {
        return this.buildingCardsStones;
    }

    public DevelopmentCardColor getCardColor() {
        return this.cardColor;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
