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
public class Controlador {
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
    @FXML
    RadioButton computervscomputer;
    @FXML
    RadioButton humanvshuman;
    @FXML
    RadioButton humanvscomputer;


    ArrayList<Button> buttons = new ArrayList<>();


    int idModo = 0;

    boolean turnoJugador = false;
    boolean turnoIA = false;

    boolean comenzarJuego=false;


    public void comprobarModo(){
        if(humanvshuman.isSelected()){
            idModo=0;

        }
        if(computervscomputer.isSelected()){
            idModo=1;
        }
        if(humanvscomputer.isSelected()){
            idModo=2;
            System.out.println("Modo humanvscompter");

        }
    }


    public void Marcar(ActionEvent event){
        //Añadir botones al array
        buttons.add(b0);
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);


        bc = (Button) event.getSource();
        String sid = bc.getId().replaceAll("[b]","");
        int id =Integer.valueOf(sid);

            if(comenzarJuego== true){
                turnoJugador=false;
                comenzarJuego=false;
            }

            if(idModo==0){
                HumanVSHuman();
            }

            if(idModo==1){
                ComputerVSComputer();
            }

            if(idModo==2){

            }


        comprobarGanador();
    }

    public void HumanVSHuman(){
        for(int i=0;i<1;i++) {
            if(bc.getText() == "X" || bc.getText() == "O"){
                winnerText.setText("No esta permitido");
                break;
            }

            if (turnoJugador == false) {
                bc.setText("X");
                turnoJugador = true;
                break;

            }

            if (turnoJugador == true) {
                turnoJugador = false;
                bc.setText("O");
                break;
            }
        }
    }

    public void ComputerVSComputer(){

        int botonIA = (int) (Math.random()*8+0);

        for(int i=0;i<1;i++) {
            //No funciona bien cambiar bc por buttons.get(botonIA).setText("X");
            if(bc.getText() == "X" || bc.getText() == "O"){
                break;
            }

            //intentar cambiar el bc para poner un numero random y q clique solo

            if (turnoIA == false) {
                buttons.get(botonIA).setText("X");
                turnoIA = true;
                break;
            }

            if (turnoIA == true) {
                buttons.get(botonIA).setText("O");
                turnoIA = false;
                break;
            }
        }
    }

    public void comprobarGanador() {
        for (int i = 0; i < 8; i++) {
            String linea = switch (i) {
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


            if (linea.equals("XXX")) {
                winnerText.setText("¡Gano X!");
                for(int j=0; j<buttons.size();j++){
                    buttons.get(j).setDisable(true);
                }

                /*
                b0.setDisable(true);
                b1.setDisable(true);
                b2.setDisable(true);
                b3.setDisable(true);
                b4.setDisable(true);
                b5.setDisable(true);
                b6.setDisable(true);
                b7.setDisable(true);
                b8.setDisable(true);

                 */

            }

            else if (linea.equals("OOO")) {
                winnerText.setText("¡Gano O!");
                for(int j=0; j<buttons.size();j++){
                    buttons.get(j).setDisable(true);
                }
                /*
                b0.setDisable(true);
                b1.setDisable(true);
                b2.setDisable(true);
                b3.setDisable(true);
                b4.setDisable(true);
                b5.setDisable(true);
                b6.setDisable(true);
                b7.setDisable(true);
                b8.setDisable(true);

                 */

            }
        }
    }

    public void comenzarJuego() {

        for(int i=0; i<buttons.size();i++){
            buttons.get(i).setDisable(false);
            buttons.get(i).setText("");
        }
        /*
        b0.setDisable(false);
        b1.setDisable(false);
        b2.setDisable(false);
        b3.setDisable(false);
        b4.setDisable(false);
        b5.setDisable(false);
        b6.setDisable(false);
        b7.setDisable(false);
        b8.setDisable(false);

         */

        /*
        b0.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");

         */

        comenzarJuego = true;
    }

    }
