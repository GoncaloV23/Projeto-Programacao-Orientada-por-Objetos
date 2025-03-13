/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import projetoPOO.Product;
import projetoPOO.Product.Type;
import projetoPOO.WareHouse;

/**
 *
 * @author Asus
 */
public class Reader {
    private List<Product> productList;
    private String line;
    private String split;
    private String csvFile;
    private List<int[]> coordinatesAGV;

    /**
     *
     */
    public Reader() {
        productList = new ArrayList<>();
        coordinatesAGV = new ArrayList<>();
        split = ",";
        csvFile = "C:\\Users\\Asus\\Desktop\\ProjetoFase2\\src\\Resource\\dados_simulacao.csv";
    }

    /**
     *
     * @return
     */
    public WareHouse getWareHouse() {
    WareHouse wareHouse = null;
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        // Read the first line of the file
        line = br.readLine();

        if (line != null) {
            String[] dimensionData = line.split(split);
            int height = Integer.parseInt(dimensionData[0].trim());
            int width = Integer.parseInt(dimensionData[1].trim());

            // Create the WareHouse object with the obtained dimensions
            wareHouse = new WareHouse(height, width);
        }
    } catch (IOException e) {
        e.getMessage();
    }

    return wareHouse;
}

    /**
     *
     * @return
     */
    public List<Product> getProducts(){
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {   
            
            br.readLine();
            
            // Processar as linhas subsequentes com as informações dos produtos
            while ((line = br.readLine()) != null) {
                if (line.equals("---")) {
                    break; 
                }
                String[] data = line.split(split);

                String name = data[0];
                double peso = Double.parseDouble(data[1]);
                String tipo = data[2];
                
                productList.add(new Product(name, peso, getTypeFromString(tipo)));
            }
        } catch (IOException e) {
            e.getMessage();
        }
        
        return productList;
    }
    
    /**
     *
     * @return
     */
    public List<int[]> getAGVCoordinates() {
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        String line = br.readLine();

        while (line != null && !line.equals("---")) {
            line = br.readLine();
        }

        line = br.readLine(); // Skip the line after the separator

        int[] coordinates;
        while (line != null) {
            String[] data = line.split(split);

            int x = Integer.parseInt(data[0].trim());
            int y = Integer.parseInt(data[1].trim());

            coordinates = new int[2];
            coordinates[0] = x;
            coordinates[1] = y;
            coordinatesAGV.add(coordinates);

            line = br.readLine();
        }
    } catch (IOException e) {
        e.getMessage();
    }

    return coordinatesAGV;
}

    
    private Type getTypeFromString(String typeString) {
        typeString = typeString.trim().toLowerCase();

        switch (typeString) {
            case "clothing":
                return Type.CLOTHING;
            case "accessories":
                return Type.ACCESSORIES;
            case "small_toys":
                return Type.SMALL_TOYS;
            case "large_toys":
                return Type.LARGE_TOYS;
            case "small_electronics":
                return Type.SMALL_ELECTRONICS;
            case "large_electronics":
                return Type.LARGE_ELECTRONICS;
            case "books":
                return Type.BOOKS;
            default:
                throw new IllegalArgumentException("Tipo de produto inválido: " + typeString);
        }
    }
}
