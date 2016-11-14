/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DataDAO;
import db.DataModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import producer.Producer;

/**
 *
 * @author Diana-Stefania
 */
public class AsyncRequestProcessor implements Runnable {
    
    private AsyncContext asyncContext;
    private String path;
    
    public AsyncRequestProcessor(AsyncContext asyncCtx, String realPath) {
        this.asyncContext = asyncCtx;
        this.path = realPath;
    }
    
    @Override
    public void run() {
                
       // String searchedFilePath = "C:\\Users\\C309558\\Desktop\\stuff\\SD\\Lab04-Server\\web\\WEB-INF\\products\\products_yyyy.MM.dd-hh.mm.txt";
        if (!checkIfFileExists(path)) {
            createFile(path);
        }
        
        String data = readFromFile();
        saveData(data);
        PrintWriter out;
        try {
            asyncContext.getResponse().setContentType("text/plain");
            out = asyncContext.getResponse().getWriter();
            out.write(data);
        } catch (IOException ex) {
            Logger.getLogger(AsyncRequestProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        asyncContext.complete();

    }
    
    private void createFile(String path) {
        try {
            Thread.sleep(10000);
            Producer producer = new Producer();
            producer.generateFile(path);
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private String readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();            
            System.out.println(everything + "   " + System.currentTimeMillis());
            
            return everything;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AsyncRequestProcessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AsyncRequestProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    private void saveData(String line) {
        String[] elements = line.split(",");
        Random random = new Random();
        if (elements.length > 0) {
            DataModel dataModel = new DataModel();
            dataModel.setMachineID(elements[0]);
            dataModel.setProductID(elements[1]);
            dataModel.setQuantity(Integer.parseInt(elements[2].trim()));
            dataModel.setPrice(random.nextFloat() * 100);
            dataModel.setTimestamp(new Timestamp(new Date().getTime()));
            
            DataDAO dataDAO = new DataDAO();
            dataDAO.insertData(dataModel);
        }
    }
    
    private boolean checkIfFileExists(String path) {
        
        File f = new File(path);
        if(f.exists()) { 
            return true;
        }
        return false;
    }

    
}
