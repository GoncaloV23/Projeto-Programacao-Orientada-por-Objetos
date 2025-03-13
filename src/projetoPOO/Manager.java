/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoPOO;

import Vehicles.TowingVehicle;
import Vehicles.ULC;
import Vehicles.RollingCart;
import Vehicles.AGV;
import Vehicles.AGC;
import java.util.ArrayList;
import IO.Reader;
import java.util.List;
import CustomExceptions.NoSpaceAvailablePackageException;
import CustomExceptions.UnsupportedPackageException;

/**
 *
 * @author Asus
 */
public class Manager {
    
    private Reader reader;
    private WareHouse w;
    private List<Product> products;
    private List<int[]> coordinates;
    private boolean nextStep;
    private AGC agc1, agc2, agc3, agc4;
    private ULC ulc1, ulc2, ulc3;
    private RollingCart rc1, rc2, rc3;
    private TowingVehicle tw1, tw2, tw3;
    private Box box1, box2, box3, box4;
    private Bag bag1, bag2, bag3;
    private CardBoardBox card1, card2, card3, card4, card5, card6;
    private Pallet pallet1, pallet2, pallet3;
    private int doneCourse = 0;
    /**
     *
     */
    public Manager(){
        reader = new Reader();
        w = reader.getWareHouse();
        products = reader.getProducts();
        coordinates = reader.getAGVCoordinates();
        nextStep = false;
        start();
    }
    
    /**
     *
     */
    public void start(){
        
        agc1 = new AGC(coordinates.get(0)[0], coordinates.get(0)[1]);
        agc2 = new AGC(coordinates.get(1)[0], coordinates.get(1)[1]);
        agc3 = new AGC(coordinates.get(2)[0], coordinates.get(2)[1]);
        agc4 = new AGC(coordinates.get(12)[0], coordinates.get(12)[1]);

        ulc1 = new ULC(coordinates.get(3)[0], coordinates.get(3)[1]);
        ulc2 = new ULC(coordinates.get(4)[0], coordinates.get(4)[1]);
        ulc3 = new ULC(coordinates.get(5)[0], coordinates.get(5)[1]);

        rc1 = new RollingCart(coordinates.get(9)[0], coordinates.get(9)[1]);
        rc2 = new RollingCart(coordinates.get(10)[0], coordinates.get(10)[1]);
        rc3 = new RollingCart(coordinates.get(11)[0], coordinates.get(11)[1]);

        tw1 = new TowingVehicle(rc1, coordinates.get(6)[0], coordinates.get(6)[1]);
        tw2 = new TowingVehicle(rc2, coordinates.get(7)[0], coordinates.get(7)[1]);
        tw3 = new TowingVehicle(rc3, coordinates.get(8)[0], coordinates.get(8)[1]);

        box1 = new Box(products.get(8));
        box2 = new Box(products.get(1));
        box3 = new Box(products.get(22));
        box4 = new Box(products.get(23));

        bag1 = new Bag(products.get(0));
        bag2 = new Bag(products.get(4));
        bag3 = new Bag(products.get(24));

        
        try{

            card1 = new CardBoardBox();
            card1.addProduct(products.get(2));
            card1.addProduct(products.get(3));
            card1.addProduct(products.get(6));
            card1.addProduct(products.get(9));
            card1.addProduct(products.get(10));
            card1.addProduct(products.get(11));
            card1.addProduct(products.get(13));
            card1.addProduct(products.get(15));
            card1.addProduct(products.get(16));
            card1.addProduct(products.get(17));

            card2 = new CardBoardBox();
            card2.addProduct(products.get(5));

            card3 = new CardBoardBox();
            card3.addProduct(products.get(12));

            card4 = new CardBoardBox();
            card4.addProduct(products.get(14));

            card5 = new CardBoardBox();
            card5.addProduct(products.get(19));

            card6 = new CardBoardBox();
            card6.addProduct(products.get(21));

            pallet1 = new Pallet();
            pallet1.addProduct(card1);
            pallet1.addProduct(card2);

            pallet2 = new Pallet();
            pallet1.addProduct(card3);
            pallet1.addProduct(card4);

            pallet3 = new Pallet();
            pallet1.addProduct(card5);
            pallet1.addProduct(card6);
            
            
            //PRODUCT POSITIONS
            w.getSlot(12, 0).setEmpty(false);
            w.getSlot(14, 0).setEmpty(false);
            w.getSlot(15, 0).setEmpty(false);
            w.getSlot(17, 0).setEmpty(false);
            w.getSlot(18, 0).setEmpty(false);
            w.getSlot(20, 0).setEmpty(false);
            w.getSlot(22, 0).setEmpty(false);
            w.getSlot(26, 0).setEmpty(false);
            w.getSlot(28, 0).setEmpty(false);
            w.getSlot(33, 0).setEmpty(false);
            

            
        } catch (UnsupportedPackageException | NoSpaceAvailablePackageException e){
            e.getMessage();
        }
    }
    
    public WareHouse getWareHouse(){
        return w;
    }

    public Reader getReader() {
        return reader;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<int[]> getCoordinates() {
        return coordinates;
    }
    
    public boolean getNextStep(){
        return nextStep;
    }
    
    public void setNextStep(boolean nextStep){
        this.nextStep = nextStep;
    }
    
    public void nextMove(){
        List<AGV> nonAutomatedVehicles = new ArrayList<>();
                nonAutomatedVehicles.add(tw1);
                nonAutomatedVehicles.add(tw2);
                nonAutomatedVehicles.add(tw3);
                nonAutomatedVehicles.add(agc1);
                nonAutomatedVehicles.add(agc2);
                nonAutomatedVehicles.add(agc3);
                nonAutomatedVehicles.add(agc4);
            
            List<AGV> automatedVehicles = new ArrayList<>();
                automatedVehicles.add(ulc1);
                automatedVehicles.add(ulc2);
                automatedVehicles.add(ulc3);
                
            int vehiclesDest = 0;
        
        //PICKUP
        while(true){
            if(automatedVehicles.size() != vehiclesDest && nextStep){
                if(doneCourse >= 1) break;
                
                ulc1.buildRoute(w, 12, 0, true, pallet1);
                ulc2.buildRoute(w, 14, 0, true, pallet2);
                ulc3.buildRoute(w, 15, 0, true, pallet3);   
            }
            for(AGV vehicle : automatedVehicles){
                if(vehicle.getX() == vehicle.getDestX() && vehicle.getY()== vehicle.getDestY()){
                    vehiclesDest++;
                }
            }

            nextStep = false;
            if(vehiclesDest == automatedVehicles.size()){
                doneCourse = 1;
            } else {
                vehiclesDest = 0;
            }   
        
            break;
        }    
        vehiclesDest = 0;

//            tw1.buildRouteTillEnd(w, 17, 0, true, bag1);
//            tw2.buildRouteTillEnd(w, 18, 0, true, bag2);
//            tw3.buildRouteTillEnd(w, 20, 0, true, box1);
//
//            agc1.buildRouteTillEnd(w, 22, 0, true, box2);
//            agc2.buildRouteTillEnd(w, 26, 0, true, box3);
//            agc3.buildRouteTillEnd(w, 28, 0, true, bag3);
//            agc4.buildRouteTillEnd(w, 33, 0, true, box4);

        while(true){
            while(nonAutomatedVehicles.size() != vehiclesDest && nextStep){
                if(doneCourse >= 2) break;
                
                tw1.buildRoute(w, 17, 0, true, bag1);
                tw2.buildRoute(w, 18, 0, true, bag2);
                tw3.buildRoute(w, 20, 0, true, box1);

                agc1.buildRoute(w, 22, 0, true, box2);
                agc2.buildRoute(w, 26, 0, true, box3);
                agc3.buildRoute(w, 28, 0, true, bag3);
                agc4.buildRoute(w, 33, 0, true, box4);

                for(AGV vehicle : nonAutomatedVehicles){
                    if(vehicle.getX() == vehicle.getDestX() && vehicle.getY()== vehicle.getDestY()){
                        vehiclesDest++;
                    }
                }
                
                nextStep = false;
                if(vehiclesDest == nonAutomatedVehicles.size()){
                    doneCourse = 2;
                } else {
                    vehiclesDest = 0;
                }
                
            } 
            break;
        }
        vehiclesDest = 0;


        //STORAGE
        while(true){
            if(automatedVehicles.size() != vehiclesDest && nextStep){
                if(doneCourse >= 3) break;
                ulc1.buildRoute(w, 0, 4, false, pallet1);
                ulc2.buildRoute(w, 0, 8, false, pallet2);
                ulc3.buildRoute(w, 0, 10, false, pallet3);
            
            for(AGV vehicle : automatedVehicles){
                if(vehicle.getX() == vehicle.getDestX() && vehicle.getY()== vehicle.getDestY()){
                    vehiclesDest++;
                }
            }

            nextStep = false;
            if(vehiclesDest == automatedVehicles.size()){
                doneCourse = 3;
            } else {
                vehiclesDest = 0;
            }   
            }
            break;
           
        }
        vehiclesDest = 0;
        

        while(true){
           while(nonAutomatedVehicles.size() != vehiclesDest && nextStep){
               if(doneCourse >= 4) break;
                tw1.buildRoute(w, 0, 15, false, bag1);
                tw2.buildRoute(w, 0, 33, false, bag2);
                tw3.buildRoute(w, 0, 36, false, box1);

                agc1.buildRoute(w, 0, 38, false, box2);
                agc2.buildRoute(w, 0, 40, false, box3);
                agc3.buildRoute(w, 0, 42, false, bag3);
                agc4.buildRoute(w, 0, 43, false, box4);

                for(AGV vehicle : nonAutomatedVehicles){
                    if(vehicle.getX() == vehicle.getDestX() && vehicle.getY()== vehicle.getDestY()){
                        vehiclesDest++;
                    }
                }
                if(vehiclesDest != nonAutomatedVehicles.size()) vehiclesDest = 0;
                else { doneCourse = 4; } 
                
                nextStep = false;

                } 
            break;
        }
        vehiclesDest = 0;


        //PICKUP (VEICULOS COM DIFERENTES PRODUTOS DOS ANTERIORES
        while(true){
            if(automatedVehicles.size() != vehiclesDest && nextStep){
                if(doneCourse >= 5) break;
                ulc1.buildRoute(w, 0, 10, true, pallet3);
                ulc2.buildRoute(w, 0, 4, true, pallet1);
                ulc3.buildRoute(w, 0, 8, true, pallet2);
            
            for(AGV vehicle : automatedVehicles){
                if(vehicle.getX() == vehicle.getDestX() && vehicle.getY()== vehicle.getDestY()){
                    vehiclesDest++;
                }
            }

            nextStep = false;
            if(vehiclesDest == automatedVehicles.size()){
                doneCourse = 5;
            } else {
                vehiclesDest = 0;
            }   
        }
            break;
        }
        vehiclesDest = 0;
        
        w.getSlot(0, 15).setEmpty(true);
        w.getSlot(0, 33).setEmpty(true);
        w.getSlot(0, 36).setEmpty(true);
        w.getSlot(0, 43).setEmpty(true);
    

        while(true){
           while(nonAutomatedVehicles.size() != vehiclesDest && nextStep){
               if(doneCourse >= 6) break;
                tw1.buildRoute(w, 0, 36, true, box1);
                tw2.buildRoute(w, 0, 15, true, bag1);
                tw3.buildRoute(w, 0, 33, true, bag2);

                agc1.buildRoute(w, 0, 43, true, box4);
                agc2.buildRoute(w, 0, 38, true, box2);
                agc3.buildRoute(w, 0, 40, true, box3);
                agc4.buildRoute(w, 0, 42, true, bag3);

                for(AGV vehicle : nonAutomatedVehicles){
                    if(vehicle.getX() == vehicle.getDestX() && vehicle.getY()== vehicle.getDestY()){
                        vehiclesDest++;
                    }
                }
                if(vehiclesDest != automatedVehicles.size()){
                    vehiclesDest = 0;
                    break;
                } else { doneCourse = 6; }
                
                nextStep = false;

                } 
            break;
        }
        vehiclesDest = 0;


        //DELIVER
        while(true){
            if(automatedVehicles.size() != vehiclesDest && nextStep){
                if(doneCourse >= 7) break;
                ulc1.buildRoute(w, 11, 49, false, pallet3);
                ulc2.buildRoute(w, 13, 49, false, pallet1);
                ulc3.buildRoute(w, 20, 49, false, pallet2);
            
            for(AGV vehicle : automatedVehicles){
                if(vehicle.getX() == vehicle.getDestX() && vehicle.getY()== vehicle.getDestY()){
                    vehiclesDest++;
                }
            }

            nextStep = false;
            if(vehiclesDest == automatedVehicles.size()){
                doneCourse = 7;
            } else {
                vehiclesDest = 0;
            }   
            }
            break;
        }
        vehiclesDest = 0;
        

        while(true){
           while(nonAutomatedVehicles.size() != vehiclesDest && nextStep){
               if(doneCourse >= 8) break;
                tw1.buildRoute(w, 22, 49, false, box1);
                tw2.buildRoute(w, 25, 49, false, bag1);
                tw3.buildRoute(w, 26, 49, false, bag2);

                agc1.buildRoute(w, 30, 49, false, box4);
                agc2.buildRoute(w, 32, 49, false, box2);
                agc3.buildRoute(w, 34, 49, false, box3);
                agc4.buildRoute(w, 36, 49, false, bag3);

                for(AGV vehicle : nonAutomatedVehicles){
                    if(vehicle.getX() == vehicle.getDestX() && vehicle.getY()== vehicle.getDestY()){
                        vehiclesDest++;
                    }
                }
                if(vehiclesDest != automatedVehicles.size()){
                    vehiclesDest = 0;
                    break;
                } else { doneCourse = 8; }
                
                nextStep = false;

                } 
            break;
        }
    }
}

