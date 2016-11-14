/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Diana-Stefania
 */
@WebListener
public class AppContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // create the thread pool
        ThreadPoolExecutor executor =  new ThreadPoolExecutor(100, 200,
                                       50000L, TimeUnit.MILLISECONDS,
                                       new ArrayBlockingQueue<Runnable>(100));
        //int corePoolSize, int maximumPoolSize,
        //long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue
        servletContextEvent.getServletContext().setAttribute("executor",executor);
    }
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) servletContextEvent
                                      .getServletContext().getAttribute("executor");
        executor.shutdown();
    }

}
