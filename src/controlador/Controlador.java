package controlador;

import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class Controlador implements Initializable {

    @FXML
    Pane panelFX;

    @FXML
    Circle bolaFXazul;

    @FXML
    Circle bolaFXroja;

    AnimationTimer timer;
    int sentidoAzul;
    int sentidoRojo;
    boolean pararTodo, pararAzul, pararRojo;

    public Controlador() {
        sentidoAzul = 5;
        sentidoRojo = -5;
        pararTodo = false;

        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (!pararTodo) {
                    if (!pararAzul) {
                        if ((bolaFXazul.getLayoutX() + sentidoAzul + 10) >= 800) {
                            sentidoAzul = sentidoAzul * -1;
                        } else if ((bolaFXazul.getLayoutX() + sentidoAzul - 10) <= 0) {
                            sentidoAzul = sentidoAzul * -1;
                        }
                        bolaFXazul.setLayoutX(bolaFXazul.getLayoutX() + sentidoAzul);
                    } else {
                        sentidoAzul = 0;
                    }

                    if (!pararRojo) {
                        if ((bolaFXroja.getLayoutX() + sentidoRojo + 10) >= 800) {
                            sentidoRojo = sentidoRojo * -1;
                        } else if ((bolaFXroja.getLayoutX() + sentidoRojo - 10) <= 0) {
                            sentidoRojo = sentidoRojo * -1;
                        }
                        bolaFXroja.setLayoutX(bolaFXroja.getLayoutX() + sentidoRojo);
                    } else {
                        sentidoRojo = 0;
                    }

                } else {
                    sentidoAzul = 0;
                    sentidoRojo = 0;
                }

            }

        };

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        panelFX.setFocusTraversable(true);
        timer.start();

    }

    public void teclaPulsada(KeyEvent tecla) {
        KeyCode code = tecla.getCode();

        switch (code) {
            case R:
                if (pararRojo == true) {
                    sentidoRojo = 5;
                    pararRojo = false;
                } else {
                    pararRojo = true;
                }
                break;
            case A:
                if (pararAzul == true) {
                    sentidoAzul = 5;
                    pararAzul = false;
                } else {
                    pararAzul = true;
                }
                break;

                case T: 
                pararTodo = true;
                break;

                case E: 
                pararTodo = false;
                pararAzul = false;
                pararRojo = false;
                sentidoAzul=5;
                sentidoRojo=-5;
                break;
            default:
            
                break;
        }

    }

}
