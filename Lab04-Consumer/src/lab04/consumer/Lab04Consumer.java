/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04.consumer;

/**
 *
 * @author Diana-Stefania
 */
public class Lab04Consumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ConsumerThread consumerThread = new ConsumerThread();
       //for (int index = 0; index < 2; index ++) {
           //consumerThread = new ConsumerThread();
           consumerThread.start();
       //}
       
    }
    
}
