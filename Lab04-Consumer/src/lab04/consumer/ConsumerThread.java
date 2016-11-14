/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04.consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Diana-Stefania
 */
public class ConsumerThread extends Thread {
    @Override
    public void run() {
        Date date = new Date();
        String timestamp = new SimpleDateFormat("yyyy.MM.dd-hh.mm").format(date);
        try {
            URL url = new URL("http://localhost:8084/Lab04-Server/Service?timestamp=" + timestamp);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Content-Type", "text/plain");            
            BufferedReader in = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );
            
            //System.out.println("[" + new Date() + "] ---> Thread started" );
            String response;
            while ( (response = in.readLine()) != null ) {
                System.out.println( response );
            }
            in.close();
            //System.out.println("[" + new Date() + "] ---> Thread stopped" );
        } catch ( MalformedURLException ex ) {
            // a real program would need to handle this exception
            System.err.println(ex.getStackTrace());
        } catch ( IOException ex ) {
            // a real program would need to handle this exception
             System.err.println(ex.getStackTrace());
        }
    }
}
