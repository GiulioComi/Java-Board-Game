package it.polimi.ingsw.LM34.UI.GUI;


import it.polimi.ingsw.LM34.Enums.Controller.LeaderCardsAction;
import it.polimi.ingsw.LM34.Enums.Controller.PlayerSelectableContexts;
import it.polimi.ingsw.LM34.Enums.UI.NetworkType;
import it.polimi.ingsw.LM34.Model.Boards.GameBoard.Market;
import it.polimi.ingsw.LM34.Model.Boards.GameBoard.Tower;
import it.polimi.ingsw.LM34.Model.Player;
import it.polimi.ingsw.LM34.Network.Client.AbstractClient;
import it.polimi.ingsw.LM34.Network.Client.ClientNetworkController;
import it.polimi.ingsw.LM34.Network.Client.RMI.RMIClient;
import it.polimi.ingsw.LM34.Network.Client.Socket.SocketClient;
import it.polimi.ingsw.LM34.UI.GUI.GuiViews.*;
import it.polimi.ingsw.LM34.UI.UIInterface;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladc on 6/6/2017.
 */
public class GUI extends Application implements UIInterface {
    private AbstractClient networkClient;
    private ClientNetworkController networkController;


    @Override
    public void show() {
        launch(null);
    }

    @Override
    public void loginMenu() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/gui.fxml"));
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        double width = gd.getDisplayMode().getWidth();
        double height = gd.getDisplayMode().getHeight();
        primaryStage.setMaxWidth(width);
        primaryStage.setMaxHeight(height);
        prepareWindow(primaryStage, root);
        //servantsSelection(5,1);
        //curchReportDecision(4,2);
        //leaderCardAction(primaryStage); //TODO
        //addPlayersInfo(root);
        loginMenu(primaryStage);
        //connectionTypeSelection();
        //endGame(primaryStage);



        primaryStage.show();

    }

    private void endGame(Stage primaryStage) {
        EndGameDialog dialog = new EndGameDialog();
        try {
            dialog.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void leaderCardAction(Stage primaryStage) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource("gui/leaderCardAction.fxml"));
            primaryStage.setScene(new Scene(
                    root2, 500, 400));
            primaryStage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private void addPlayersInfo(Parent root) {
        ScrollPane scrollPane = (ScrollPane) root.lookup("#scrollPanePaneResource");
        VBox content = new VBox();
        scrollPane.setContent(content);
        // Just to see that the lines are actually added
        scrollPane.setPrefWidth(200);

        for (Integer i = 1; i < 5; i++) {
            ImageView imageView = new ImageView();
            imageView.setImage(new Image(Thread.currentThread().getContextClassLoader().getResource("images/icon.png").toExternalForm()));
            imageView.minHeight(200);
            imageView.minWidth(250);
            imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    System.out.println("Mouse entered");
                }
            });
            //scrollPane.getRowConstraints().add(new RowConstraints(30));
            content.getChildren().add(imageView);
        }
    }

    private void prepareWindow(Stage primaryStage, Parent root) {
        primaryStage.getIcons().add(new Image(Thread.currentThread().getContextClassLoader().getResource("images/icon.png").toExternalForm()));
        primaryStage.setTitle("Lorenzo il Magnifico by CranioCreations");
        primaryStage.setScene(new Scene(root, primaryStage.getMaxWidth(), primaryStage.getMaxHeight()));
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(true);
        primaryStage.show();
    }


    public void loginMenu(Stage primaryStage) {
        try {
            LoginDialog dialog = new LoginDialog();
            dialog.start(primaryStage);
           // networkController.login(dialog.getUsername().getText(), dialog.getPassword().getText());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loginResult(Boolean result) {

    }

    @Override
    public NetworkType connectionTypeSelection() {
        NetworkTypeDialog dialog = new NetworkTypeDialog();
        NetworkType networkType = dialog.interactWithPlayer();

        if(networkType == NetworkType.RMI)
            this.networkClient = new RMIClient(SERVER_IP, RMI_PORT, this);
        else
            this.networkClient = new SocketClient(SERVER_IP, SOCKET_PORT, this);

            this.networkController = networkClient.getNetworkController();

            return null; //TODO
    }

    @Override
    public Integer contextSelection(List<PlayerSelectableContexts> allContext) {
        return null;
    }

    @Override
    public String towerSlotSelection(Integer towerNumber, Integer towerFloor) {
        return null;
    }

    @Override
    public Integer servantsSelection(Integer servantsAvailable, Integer minimumServantsRequested) {
        //UseServantsDialog dialog = new UseServantsDialog(networkClient);
         //new UseServantsController(dialog.interactWithPlayer(servantsAvailable, minimumServantsRequested));
    return 0; //TODO
    }


    public Integer curchReportDecision(Integer servantsAvailable, Integer minimumServantsRequested) {
        CurchReportDialog dialog = new CurchReportDialog();
         return dialog.interactWithPlayer(servantsAvailable, minimumServantsRequested);
    }

    @Override
    public Integer leaderCardAction(List<String> playerLeaderCards, LeaderCardsAction action) {
        return null;
    }

    @Override
    public Integer marketSlotSelection(Market market) {
        return null;
    }

    @Override
    public void workingArea(String workingAreaChoice, Player player) {

    }

    @Override
    public void printTowers(ArrayList<Tower> towers) {

    }

    @Override
    public void printGameBoard() {

    }


    public static void main(String [] args) {
        GUI gui = new GUI();
        gui.show();
    }
}