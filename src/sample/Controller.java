package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.stage.StageStyle;
import java.util.Optional;
import java.util.Random;


public class Controller {


    @FXML
    private Button newGameButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button gridPaneButton1;

    @FXML
    private Button gridPaneButton2;

    @FXML
    private Button gridPaneButton3;

    @FXML
    private Button gridPaneButton4;

    @FXML
    private Button gridPaneButton5;

    @FXML
    private Button gridPaneButton6;

    @FXML
    private Button gridPaneButton7;

    @FXML
    private Button gridPaneButton8;

    @FXML
    private Button gridPaneButton9;

    private boolean gameTurn = false;
    public Button[] arrayButtons;
    private Random generator = new Random();
    private boolean move = true;


    public void newGameButton() {
        newGameButton.setOnAction(event -> {
            initializeButtonArray();
            for (int i = 0; i < arrayButtons.length; i++) {
                arrayButtons[i].setText("");
                arrayButtons[i].setStyle("-fx-background-color: #fbf6f3");
            }
            move = true;
            gameTurn = false;
        });
    }

    public void infoButton() {
        infoButton.setOnAction(event -> {
            Dialog<ButtonType> dialog = new Dialog<>();
            ButtonType okButton = ButtonType.OK;
            dialog.getDialogPane().getButtonTypes().add(okButton);
            dialog.initStyle(StageStyle.UNDECORATED);
            dialog.setContentText("The first player to get 3 of her marks in a row (up, down, across, or diagonally) " +
                    "is the winner. When all 9 squares are full, the game is over.");
            dialog.getDialogPane().setPrefHeight(200);
            dialog.getDialogPane().setPrefWidth(130);
            Platform.runLater(() -> {
                Optional<ButtonType> response = dialog.showAndWait();
                response.ifPresent(System.out::println);
            });
        });
    }

    public void exitButton() {
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
    }

    public boolean gameEnd() {
        if (!"".equals(gridPaneButton1.getText()) && gridPaneButton1.getText().equals(gridPaneButton2.getText())
                && gridPaneButton2.getText().equals(gridPaneButton3.getText())) {
            gridPaneButton1.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton2.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton3.setStyle("-fx-background-color: #52c6ca");
            move = false;
            return true;
        }

        if (!"".equals(gridPaneButton4.getText()) && gridPaneButton4.getText().equals(gridPaneButton5.getText())
                && gridPaneButton5.getText().equals(gridPaneButton6.getText())) {
            gridPaneButton4.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton5.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton6.setStyle("-fx-background-color: #52c6ca");
            move = false;
            return true;
        }

        if (!"".equals(gridPaneButton7.getText()) && gridPaneButton7.getText().equals(gridPaneButton8.getText())
                && gridPaneButton8.getText().equals(gridPaneButton9.getText())) {
            gridPaneButton7.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton8.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton9.setStyle("-fx-background-color: #52c6ca");
            move = false;
            return true;
        }

        if (!"".equals(gridPaneButton1.getText()) && gridPaneButton1.getText().equals(gridPaneButton4.getText())
                && gridPaneButton4.getText().equals(gridPaneButton7.getText())) {
            gridPaneButton1.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton4.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton7.setStyle("-fx-background-color: #52c6ca");
            move = false;
            return true;
        }


        if (!"".equals(gridPaneButton2.getText()) && gridPaneButton2.getText().equals(gridPaneButton5.getText())
                && gridPaneButton5.getText().equals(gridPaneButton8.getText())) {
            gridPaneButton2.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton5.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton8.setStyle("-fx-background-color: #52c6ca");
            move = false;
            return true;
        }

        if (!"".equals(gridPaneButton3.getText()) && gridPaneButton3.getText().equals(gridPaneButton6.getText())
                && gridPaneButton6.getText().equals(gridPaneButton9.getText())) {
            gridPaneButton3.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton6.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton9.setStyle("-fx-background-color: #52c6ca");
            move = false;
            return true;
        }

        if (!"".equals(gridPaneButton1.getText()) && gridPaneButton1.getText().equals(gridPaneButton5.getText())
                && gridPaneButton5.getText().equals(gridPaneButton9.getText())) {
            gridPaneButton1.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton5.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton9.setStyle("-fx-background-color: #52c6ca");
            move = false;
            return true;
        }

        if (!"".equals(gridPaneButton3.getText()) && gridPaneButton3.getText().equals(gridPaneButton5.getText())
                && gridPaneButton5.getText().equals(gridPaneButton7.getText())) {
            gridPaneButton3.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton5.setStyle("-fx-background-color: #52c6ca");
            gridPaneButton7.setStyle("-fx-background-color: #52c6ca");
            move = false;
            return true;
        }

        if (!"".equals(gridPaneButton1.getText())
                && !"".equals(gridPaneButton2.getText()) && !"".equals(gridPaneButton3.getText())
                && !"".equals(gridPaneButton4.getText()) && !"".equals(gridPaneButton5.getText())
                && !"".equals(gridPaneButton6.getText()) && !"".equals(gridPaneButton7.getText())
                && !"".equals(gridPaneButton8.getText()) && !"".equals(gridPaneButton9.getText())) {
            move = false;
            return true;
        }
        return false;
    }


    public void initializeButtonArray() {
        arrayButtons = new Button[9];
        arrayButtons[0] = gridPaneButton1;
        arrayButtons[1] = gridPaneButton2;
        arrayButtons[2] = gridPaneButton3;
        arrayButtons[3] = gridPaneButton4;
        arrayButtons[4] = gridPaneButton5;
        arrayButtons[5] = gridPaneButton6;
        arrayButtons[6] = gridPaneButton7;
        arrayButtons[7] = gridPaneButton8;
        arrayButtons[8] = gridPaneButton9;
    }

    public void computerMove() {
        boolean draw = false;

        while (!draw) {
            int rand = generator.nextInt(arrayButtons.length);
            if ("" == arrayButtons[rand].getText()) {
                arrayButtons[rand].setText("O");
                draw = true;
            }
        }
    }


    public void buttonHandle(ActionEvent event) {
        initializeButtonArray();
        if (!gameEnd()) {
            for (int i = 0; i < arrayButtons.length; i++) {
                if (!gameTurn && move) {
                    if ("" == arrayButtons[i].getText() && arrayButtons[i] == event.getTarget()) {
                        arrayButtons[i].setText("X");
                        gameTurn = true;
                        gameEnd();
                    }
                }

                if (gameTurn && move) {
                    computerMove();
                    gameTurn = false;
                    gameEnd();
                }

            }

        }
    }
}



