/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Graphics;


import javafx.application.Application;
import javafx.stage.Stage;

public class Simulator extends Application {
    private Menu simulation;

    @Override
    public void start(Stage primaryStage) throws Exception {
        simulation = new Menu();
        
        simulation.start(primaryStage);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
