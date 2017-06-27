package it.polimi.ingsw.LM34.Model.Cards;

import it.polimi.ingsw.LM34.Enums.Model.DevelopmentCardColor;
import it.polimi.ingsw.LM34.Model.Effects.AbstractEffect;
import it.polimi.ingsw.LM34.Model.Effects.ResourceRelatedBonus.ResourcesBonus;
import it.polimi.ingsw.LM34.Model.Resources;

import java.util.List;

public class TerritoryCard extends AbstractDevelopmentCard {
    private DevelopmentCardColor color= DevelopmentCardColor.GREEN;
    private String name;
    private Integer period;
    private Integer diceValueToHarvest;
    private Resources resourceRequired;


    //territories does not cost anytype of resources or points as said in the game rules
    public TerritoryCard(String territoryName, Integer diceValueToHarvest, Integer period, List<AbstractEffect> instantBonus, ResourcesBonus  permanentBonus) {
        this.name = territoryName;
        this.period = period;
        this.diceValueToHarvest = diceValueToHarvest;
        this.permanentBonus = permanentBonus;
        this.instantBonus = instantBonus;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getPeriod() {
        return this.period;
    }

    /**
     *
     * @return a resources with all type of goods set to 0 because territory cards do not have requirements
     */
    @Override
    public Resources getResourcesRequired() {
        return new Resources();
    }

    @Override
    public DevelopmentCardColor getColor() { return this.color; }

    public Integer getDiceValueToHarvest() {
        return diceValueToHarvest;
    }
}
