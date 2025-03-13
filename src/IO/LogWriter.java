/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Asus
 */
public class LogWriter {

    /**
     *
     * @param texto
     */
    public void writeText(String texto) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\Asus\\Desktop\\ProjetoFase2\\src\\Resource\\log.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(texto);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao gravar no arquivo: " + e.getMessage());
        }
    }
}
