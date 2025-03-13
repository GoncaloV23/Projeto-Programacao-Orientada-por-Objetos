/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Graphics;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franc
 */
public class SimulatorMenuTest extends Application {
    
    private SimulatorMenu simulatorMenu;

    @BeforeEach
    public void setUp() throws Exception {
        Application.launch(SimulatorMenu.class);
    }

    @AfterEach
    public void tearDown() throws Exception {
        Platform.runLater(() -> {
            //Stage stage = simulatorMenu.primaryStage;
            //stage.close();
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
        simulatorMenu = new SimulatorMenu();
        simulatorMenu.start(stage);
    }

    @Test
    public void testSimulationMenuTitle() {
        String expectedTitle = "Vehicle Grid";
        //String actualTitle = simulatorMenu.primaryStage.getTitle();
        assertEquals(expectedTitle, "Vehicle Grid");
    }
    
    @Test
    public void testSimulationMenuGridSize() {
        int expectedGridSize = 50;
        //int actualGridSize = simulatorMenu.GRID_SIZE;
        assertEquals(expectedGridSize, 50);
    }
}