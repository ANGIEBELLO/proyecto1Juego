/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class JuegoMatematicasFX extends Application {
    private Random random;
    private Label preguntaLabel;
    private TextField respuestaTextField;
    private Label resultadoLabel;
    private Button siguienteButton;

    private int puntaje;
    private int totalPreguntas;
    private int preguntaActual;
    private int numero1;
    private int numero2;
    private int respuestaCorrecta;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        random = new Random();
        puntaje = 0;
        totalPreguntas = 5;
        preguntaActual = 0;

        primaryStage.setTitle("Jungla de Matemática");
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(20));

        preguntaLabel = new Label();
        preguntaLabel.setStyle("-fx-font-size: 18px");

        respuestaTextField = new TextField();
        respuestaTextField.setStyle("-fx-font-size: 16px");

        resultadoLabel = new Label();
        resultadoLabel.setStyle("-fx-font-size: 16px");

        siguienteButton = new Button("Siguiente");
        siguienteButton.setStyle("-fx-font-size: 16px");
        siguienteButton.setDisable(false);
        siguienteButton.setOnAction(e -> verificarRespuesta());

        root.getChildren().addAll(preguntaLabel, respuestaTextField, resultadoLabel, siguienteButton);

        siguientePregunta();

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void siguientePregunta() {
        if (preguntaActual < totalPreguntas) {
            preguntaActual++;

            numero1 = random.nextInt(10);
            numero2 = random.nextInt(10);
            respuestaCorrecta = numero1 + numero2;

            preguntaLabel.setText("Pregunta " + preguntaActual + ": Cuánto es " + numero1 + " + " + numero2 + "?");
            respuestaTextField.clear();
            resultadoLabel.setText("");

            respuestaTextField.setEditable(true);
        } else {
            resultadoLabel.setText("Juego terminado. Tu puntaje final es: " + puntaje + "/" + totalPreguntas);
            respuestaTextField.setEditable(false);
            siguienteButton.setDisable(true);
        }
    }

    private void verificarRespuesta() {
        int respuestaUsuario = Integer.parseInt(respuestaTextField.getText());

        if (respuestaUsuario == respuestaCorrecta) {
            resultadoLabel.setText("¡Respuesta correcta!");
            puntaje++;
        } else {
            resultadoLabel.setText("Respuesta incorrecta. La respuesta correcta era: " + respuestaCorrecta);
        }

        siguientePregunta();
    }
}
