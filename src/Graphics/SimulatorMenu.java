/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import java.util.List;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import projetoPOO.Manager;
import projetoPOO.Product;
import projetoPOO.SlotInformation;
import projetoPOO.WareHouse;

/**
 *
 * @author Asus e franc
 */
public class SimulatorMenu extends Application{
    private static final int GRID_SIZE = 50; // Size of the grid
    private static final int CELL_SIZE = 10; // Size of each cell
    
    private Manager manager = new Manager();
    private WareHouse w = manager.getWareHouse();

    private Rectangle[][] grid; // Grid of rectangles representing cells

    private int currentX = 0; // Current x-coordinate of the vehicle
    private int currentY = 0; // Current y-coordinate of the vehicle

    private int destinationX = GRID_SIZE - 1;
    private int destinationY = GRID_SIZE - 1;
    
    private int clickCount = 0;
    
    /*
    private Reader reader = new Reader();
    private List<Product> list = new ArrayList<>();
    */
    
    
 @Override
public void start(Stage primaryStage) {
    
    List<Product> list = manager.getProducts();
    
    GridPane root = new GridPane();
    grid = new Rectangle[GRID_SIZE][GRID_SIZE];

    // Create and initialize the grid of rectangles
    for (int row = 0; row < GRID_SIZE; row++) {
        for (int col = 0; col < GRID_SIZE; col++) {
            Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
            rect.setFill(Color.WHITE);
            rect.setStroke(Color.BLACK);
            rect.setStrokeWidth(0.1);

            SlotInformation slotInfo = w.getSlot(row, col);
            switch (slotInfo.getRole()) {
                case FLOOR:
                    rect.setFill(Color.WHITE);
                    break;
                case PICKUP:
                    rect.setFill(Color.BLUE);
                    break;
                case DELIVER:
                    rect.setFill(Color.RED);
                    break;
                case STORAGE:
                    rect.setFill(Color.GREEN);
                    break;
            }
            if(slotInfo.isOccupied()){
                rect.setFill(Color.YELLOW);
            }
            if(!slotInfo.isEmpty()){
                rect.setFill(Color.PURPLE);
            }
            grid[row][col] = rect;
            root.add(rect, col, row);
        }
    }

    //Scene scene = new Scene(root, 1000, 600);
    primaryStage.setTitle("Vehicle Grid");

    /* Create an HBox to contain the buttons
    HBox buttonBox = new HBox();
    buttonBox.setAlignment(Pos.CENTER);
    buttonBox.setSpacing(10); // Set the spacing between buttons

    // Create a VBox to contain the buttonBox
    VBox buttonContainer = new VBox();
    buttonContainer.setAlignment(Pos.CENTER);
    buttonContainer.setSpacing(10); // Set the spacing between the buttonBox and the gridpane
    buttonContainer.getChildren().add(buttonBox);*/

    // Create a GridPane to contain the root GridPane and the buttonContainer
    GridPane containerPane = new GridPane();
    containerPane.setAlignment(Pos.TOP_RIGHT);
    containerPane.setHgap(40);
    
    // Set up column constraints
    ColumnConstraints column1 = new ColumnConstraints();
    column1.setHgrow(Priority.ALWAYS); // Coluna 1 se expande horizontalmente
    ColumnConstraints column2 = new ColumnConstraints();
    column2.setHgrow(Priority.NEVER); // Coluna 2 mantém tamanho fixo
    RowConstraints row1 = new RowConstraints();
    row1.setVgrow(Priority.ALWAYS);
    
    containerPane.getColumnConstraints().addAll(column1, column2);
    containerPane.getRowConstraints().add(row1);
    
    VBox listContainer = new VBox();
    listContainer.setAlignment(Pos.TOP_LEFT);
    listContainer.setSpacing(10);
    
            
    containerPane.add(root, 1, 0); // Add the root GridPane to the containerPane
    //containerPane.add(buttonContainer, 0, 1); // Add the buttonContainer below the root GridPane

    /* Create a VBox to contain the root GridPane and the list
    HBox container = new HBox();
    container.setAlignment(Pos.CENTER);
    container.setSpacing(10); */ //Set the spacing between the root and the list
    
    VBox listContainer2 = new VBox();
    listContainer.setAlignment(Pos.TOP_LEFT);
    listContainer.setSpacing(10);

    // Create a label for the list
    Label label = new Label("Lista de Produtos");
    label.setFont(Font.font("Arial", FontWeight.BOLD, 40)); // Set font and style for the label

    // Create a ListView for the list
    ListView<String> listView = new ListView<>();
    ObservableList<String> items = FXCollections.observableArrayList(); // Replace with your actual list items
    for (Product product : list) {
        String itemText = product.getName() + " | Peso: " + product.getWeight() + "kg | Tipo: " + product.getType();
        items.add(itemText);
    }
    listView.setItems(items); // Replace with your actual list items
    //listView.setItems(items);
    
    listView.setPrefWidth(100); // Adjust the width as desired
    listView.setPrefHeight(500);
    
    HBox h1 = new HBox();
    HBox h2 = new HBox();
    
    Label label2 = new Label("Vermelho: Entrega\t\t");
    label2.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    label2.setStyle("-fx-text-fill:RED;");
    
    Label label3 = new Label("Verde: Armazem\t\t");
    label3.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    label3.setStyle("-fx-text-fill:GREEN;");
    
    Label label4 = new Label("Azul: Levantamento\t\t");
    label4.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    label4.setStyle("-fx-text-fill:BLUE;");
    
    Label label5 = new Label("Amarelo: Carros\t\t");
    label5.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    label5.setStyle("-fx-text-fill:ORANGE;");
    
    Label label6 = new Label("Roxo: Produtos");
    label6.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    label6.setStyle("-fx-text-fill:PURPLE;");
    
    Label countLabel = new Label("Cliques: " + clickCount);
    countLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    
    h1.getChildren().addAll(label2, label3, countLabel);
    h2.getChildren().addAll(label4, label5, label6);
    
    listContainer2.getChildren().addAll(label, listView, h1, h2);
    listContainer2.setSpacing(10);
    listContainer.getChildren().add(listContainer2);

    // Add the listContainer to the containerPane
    containerPane.add(listContainer, 0, 0);

    // Create an HBox to contain the buttons
    HBox buttonBox = new HBox();
    buttonBox.setAlignment(Pos.CENTER);
    buttonBox.setSpacing(10); // Set the spacing between buttons

    // Create two buttons
    Button button1 = new Button("Próximo Passo");
    button1.setOnAction(e -> {
        manager.setNextStep(true);
        manager.nextMove();
        
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.BLACK);
                rect.setStrokeWidth(0.1);

                SlotInformation slotInfo = w.getSlot(row, col);
                switch (slotInfo.getRole()) {
                    case FLOOR:
                        rect.setFill(Color.WHITE);
                        break;
                    case PICKUP:
                        rect.setFill(Color.BLUE);
                        break;
                    case DELIVER:
                        rect.setFill(Color.RED);
                        break;
                    case STORAGE:
                        rect.setFill(Color.GREEN);
                        break;
                }
                if(slotInfo.isOccupied()){
                    rect.setFill(Color.YELLOW);
                    animateCell(rect);
                }
                if(!slotInfo.isEmpty()){
                    rect.setFill(Color.PURPLE);
                }
                grid[row][col] = rect;
                root.add(rect, col, row);
            }
        }
        clickCount++;
        countLabel.setText("Cliques: " + clickCount);
    });
    
    Button button2 = new Button("Voltar no Menu");
    
    button2.setOnAction(e -> {
        // Create a new instance of the Menu class
        Menu menu = new Menu();

        // Create a new stage
        Stage menuStage = new Stage();

        // Call the start method of the Menu class and pass the new stage
        menu.start(menuStage);

        // Close the current stage (SimulatorMenu)
        primaryStage.close();
    });

    // Add the buttons to the buttonBox
    buttonBox.getChildren().addAll(button1, button2);

    // Add the buttonBox to the containerPane
    containerPane.add(buttonBox, 1, 1);

    // Set the size of the containerPane to occupy the upper right quarter of the scene
    //containerPane.setMaxSize(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);

    // Set the containerPane as the root of the scene
    primaryStage.setScene(new Scene(containerPane, 1200, 600));
    primaryStage.show();

    root.requestFocus();
  }

    //Animação dos carros
    private void animateCell(Node node) {
        Duration duration = Duration.millis(500);
        ScaleTransition transition = new ScaleTransition(duration, node);
        transition.setAutoReverse(true);
        transition.setCycleCount(2);
        transition.setFromX(1.0);
        transition.setFromY(1.0);
        transition.setToX(1.2);
        transition.setToY(1.2);
        transition.play();
    }
}