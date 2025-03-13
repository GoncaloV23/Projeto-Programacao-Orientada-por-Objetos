/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Asus e franc
 */
public class Menu extends Application {
    Button startSimulation;

    // Dimensões predefinidas da janela
    private final double PREDIFINE_WIDTH = 1000;
    private final double PREDIFINE_Heigth = 600;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setSpacing(50);

        try (InputStream is = Files.newInputStream(Paths.get("C:\\Users\\Asus\\Desktop\\ProjetoFase2\\src\\Resource\\Limpeza-armazem.JPG"))) {
            // Carrega uma imagem a partir de um arquivo
            ImageView img = new ImageView(new Image(is));
            img.setFitWidth(PREDIFINE_WIDTH);
            img.setFitHeight(PREDIFINE_Heigth);

            StackPane stackPane = new StackPane();
            stackPane.getChildren().addAll(img);

            // Cria um título para o menu principal
            Label title = new Label("Menu Principal");
            title.setTextFill(Color.WHITE);
            title.setFont(Font.font("Arial", FontWeight.BOLD, 35));
            title.setAlignment(Pos.CENTER);

            // Adiciona um efeito de sombra ao título
            DropShadow dropShadow = new DropShadow();
            dropShadow.setColor(Color.BLACK);
            dropShadow.setRadius(20);
            dropShadow.setSpread(0);
            title.setEffect(dropShadow);
            title.setAlignment(Pos.CENTER);

            // Cria um botão "Começar Simulação"
            Button startSimulation = new Button("Começar Simulação");
            startSimulation.setOnAction(e -> {
                // Inicia o menu do simulador
                SimulatorMenu simulatorMenu = new SimulatorMenu();
                simulatorMenu.start(primaryStage);
            });
            startSimulation.setPrefWidth(150);
            startSimulation.setPrefHeight(35);

            // Cria um botão "Sair"
            Button exitButton = new Button("Sair");
            exitButton.setOnAction(e -> {
                // Fecha a aplicação
                Platform.exit();
            });
            exitButton.setPrefWidth(150);
            exitButton.setPrefHeight(35);

            // Adiciona um evento ao botão "Sair" para fechar a aplicação
            exitButton.setOnAction(e -> {
                Platform.exit();
            });

            VBox overlayContent = new VBox();
            overlayContent.setAlignment(Pos.CENTER);
            overlayContent.setSpacing(30);

            overlayContent.getChildren().add(title);

            // Adiciona um espaçador entre o título e o botão "Começar Simulação"
            Region spacer1 = new Region();
            spacer1.setPrefHeight(10);
            overlayContent.getChildren().add(spacer1);

            overlayContent.getChildren().add(startSimulation);

            // Adiciona um espaçador entre o botão "Começar Simulação" e o botão "Sair"
            Region spacer2 = new Region();
            spacer2.setPrefHeight(10);
            overlayContent.getChildren().add(spacer2);

            overlayContent.getChildren().add(exitButton);

            stackPane.getChildren().add(overlayContent);
            StackPane.setAlignment(overlayContent, Pos.CENTER);

            root.getChildren().add(stackPane);
        } catch (IOException e) {
            System.out.println("Não deu");
        }

        Scene scene = new Scene(root, PREDIFINE_WIDTH, PREDIFINE_Heigth);
        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
