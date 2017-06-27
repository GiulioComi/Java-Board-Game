package it.polimi.ingsw.LM34.UI.GUI.GuiViews;

import it.polimi.ingsw.LM34.Network.Client.AbstractClient;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UseServantsDialog implements DialogInterface {
    AbstractClient networkClient;

    public UseServantsDialog() {}
    public UseServantsDialog(AbstractClient networkClient) {
        this.networkClient = networkClient;
    }
    public Integer interactWithPlayer(Integer servantsAvailable, Integer minimumServantsRequested) {
        List<String> choices = new ArrayList<>();
        Integer servantsToUse;
        for(Integer i = minimumServantsRequested; i < servantsAvailable; i++ )
            choices.add(i.toString());

        ChoiceDialog<String> dialog = new ChoiceDialog<>("minimumServantsRequested", choices);
        dialog.setTitle("Servants Selection");
        dialog.setGraphic(new ImageView(Thread.currentThread().getContextClassLoader().getResource("images/servants.png").toExternalForm()));
        dialog.setHeaderText("Increase family member value by using servants");
        dialog.setContentText("Choose number of servants:");

        Optional<String> result = dialog.showAndWait();

        return Integer.parseInt(result.get());
    }

    @Override
    public void setStyle(Dialog dialog) {

    }
}

