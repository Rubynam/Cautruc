/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;


import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;
/**
 *
 * @author Ruby
 */
class MyLog {

    private static Logger log ;
    private static FileHandler fhl;
    public static String DEFAULT_LINK = "C:/Users/Public/Desktop/MyLog.txt";
    
    private static FileHandler write(){
        try{
            if(fhl == null){
                fhl = new FileHandler(DEFAULT_LINK);
            }
        }catch(Exception e){
            System.out.println("Loi" + e);
        }
        return fhl;
    }
    
    
    public static Logger getInstance()
    {
        if(log==null){
            try{
                log = Logger.getLogger("InfoLogging");
                log.addHandler(write());
                SimpleFormatter formater = new SimpleFormatter();
                write().setFormatter(formater);
            }catch(Exception e){
                System.out.println("Loi" + e);
            }
        }
        return log;
    }  
}

public class Demo
{
    public static void main(String[] args)
    {
        Logger log = MyLog.getInstance();
        log.info("Hello Phuc");
        
        Logger log2 = MyLog.getInstance();
        log.info("ZLogger 2");
    }
}


