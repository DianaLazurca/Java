/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Diana-Stefania
 */
@WebListener
public class AppAsyncListener implements AsyncListener {
     public void onStartAsync(AsyncEvent event) throws IOException {
     }
     public void onComplete(AsyncEvent event) throws IOException {
     }
     public void onTimeout(AsyncEvent event) throws IOException {
        System.out.println("AppAsyncListener.onTimeout");
        ServletResponse response = event.getAsyncContext().getResponse();
        PrintWriter out = response.getWriter();
        out.write("TimeOut Error in Processing");
     }
     public void onError(AsyncEvent event) throws IOException {
     }

}
