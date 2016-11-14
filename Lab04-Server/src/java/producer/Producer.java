/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Diana-Stefania
 */
public class Producer {
    private List<String> machinesIDs = Arrays.asList("M0000", "M0001", "M0010", "M0011", "M0100", "M0101", "M0110", "M0111",
                                                    "M1000", "M1001", "M1010", "M1011", "M1100", "M1101", "M1110", "M1111");
    private List<String> productsIDs = Arrays.asList("P0000", "P0001", "P0010", "P0011", "P0100", "P0101", "P0110", "P0111",
                                                    "P1000", "P1001", "P1010", "P1011", "P1100", "P1101", "P1110", "P1111");
    
    
    public void generateFile(String path) {
        Random random = new Random();
        int machineID = random.nextInt(16);
        int productID = random.nextInt(16);
        int quantity = random.nextInt(500);
        
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                  new FileOutputStream(path), "utf-8"));
            writer.write(machinesIDs.get(machineID) + "," + productsIDs.get(productID) + "," + quantity);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
           try {
               writer.close();
           }catch (Exception ex) {
              ex.printStackTrace(); 
           }
        }
    }
}
