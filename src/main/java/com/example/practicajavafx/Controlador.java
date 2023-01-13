package com.example.practicajavafx;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

//implements Initializable para cuando se inicie el xml iniciar lo que pongamos en el metodo
public class Controlador implements Initializable {
    @FXML
    Button b0;
    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    Button b5;
    @FXML
    Button b6;
    @FXML
    Button b7;
    @FXML
    Button b8;
    @FXML
    Button bc;
    @FXML
    private Text winnerText;

    private int playerTurn = 0;
    @FXML
    RadioButton computervscomputer;
    @FXML
    RadioButton humanvshuman;
    @FXML
    RadioButton humanvscomputer;

    @FXML
    ArrayList<Button> buttons = new ArrayList<>();

    int idModo = 0;
    public void comprobarModo(){
        if(humanvshuman.isSelected()){
            idModo=0;
        }
        if(computervscomputer.isSelected()){
            idModo=1;
            System.out.println("Modo computervscompter");
        }
        if(humanvscomputer.isSelected()){
            idModo=2;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comprobarModo();

        switch (idModo){
            case 0:
                HumanVSHuman();
                break;
        }
    }

    public void HumanVSHuman(){

    }

    public void Marcar(ActionEvent event){
        boolean x = false;
        boolean o = false;

        bc = (Button) event.getSource();
        String sid = bc.getId().replaceAll("[b]","");
        int id =Integer.valueOf(sid);

        if(bc.isPressed()){
            x=true;
            bc.setText("X");
            System.out.println("X true");
        }

        if(bc.isPressed()){
            o=true;
            bc.setText("O");
            System.out.println("Y true");
        }


    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        winnerText.setText("Tres en raya");
    }
    public void resetButton(Button button) {
        button.setDisable(false);
        button.setText("");
    }
     /*public void HumanVSHuman(){
        buttons = new ArrayList<>(Arrays.asList(b0,b1, b2, b3, b4, b5, b6, b7, b8));
        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }





    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            checkIfGameIsOver();
        });
    }

    public void setPlayerSymbol(Button button) {
        if (playerTurn % 2 == 0) {
            button.setText("X");
            playerTurn = 1;
        } else {
            button.setText("O");
            playerTurn = 0;
        }
    }

    public void checkIfGameIsOver() {
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> b0.getText() + b1.getText() + b2.getText();
                case 1 -> b3.getText() + b4.getText() + b5.getText();
                case 2 -> b6.getText() + b7.getText() + b8.getText();
                case 3 -> b0.getText() + b4.getText() + b8.getText();
                case 4 -> b2.getText() + b4.getText() + b6.getText();
                case 5 -> b0.getText() + b3.getText() + b6.getText();
                case 6 -> b1.getText() + b4.getText() + b7.getText();
                case 7 -> b2.getText() + b5.getText() + b8.getText();
                default -> null;
            };

            //X winner
            if (line.equals("XXX")) {
                winnerText.setText("X won!");
                return;
            }

            //O winner
            else if (line.equals("OOO")) {
                winnerText.setText("O won!");
                return;
            }
        }

  */
    }
