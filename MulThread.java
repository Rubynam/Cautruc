/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Admin
 */

class History{
        private static FileHandler fhl;
        public static String DEFAULT_LINK = "C:/Users/GV/Desktop/MyLogThread.txt";
        
        public static FileHandler write() throws IOException{
            if(fhl==null){
                synchronized(History.class){
                    if(fhl==null){
                        fhl = new FileHandler(DEFAULT_LINK);
                    }
                }
            }
            return fhl;
        }
}
public class MulThread {
        private static Logger log;

        
        public static Logger getInstance() throws IOException
        {
            if(log==null){
                synchronized(MulThread.class){
                    if(log==null){
                        log = Logger.getLogger("Multi Logger Info");
                        log.addHandler(History.write());
                        SimpleFormatter formatter = new SimpleFormatter();
                        History.write().setFormatter(formatter);
                        log.info("My log on mul thread:");
                    }   
                }
            }
            return log;
        }
        
        public static void main(String[] args)
        {
            Thread A = new Thread(new Runnable(){
                @Override
                public void run() {
                    try{
                    Logger logA = MulThread.getInstance();
                    logA.info("THread A run : Hello Mai");
                    }catch(IOException e){
                        System.out.println("Loi "+ e);
                    }
                }
                
            }, "Thread A will start");
            
            Thread B = new Thread(new Runnable(){
                @Override
                public void run(){
                    try{
                    Logger logB = MulThread.getInstance();
                    logB.info("Thread B run");
                    }catch(IOException e){
                        System.out.println("Loi" + e);
                    }
                }
            },"Thread B will start");
            A.start();
            B.start();
        }
}
