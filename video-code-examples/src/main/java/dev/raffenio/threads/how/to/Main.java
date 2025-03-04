package dev.raffenio.threads.how.to;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("START Main");

        //dos formas de hacer hilo

        //1. Extender la clase Thread
        MyThread myThread = new MyThread();//Herencia
        myThread.start();

        //2- Implementar la interfaz Runnable
        MyRunnable runnable = new MyRunnable();
        Thread myRunnable = new Thread(runnable);
        myRunnable.start();

        logger.info("END Main");
    }


    private static int counter = 0;

    //comentar / descomentar la palabra reservada synchronized para ver el ejemplo de concurrencia
    public static /*synchronized*/ void increment(String from){
        counter++;
        logger.info("Counter: {} from: {} ",counter,from);
    }

}



class MyThread extends Thread{
    private final Logger logger = LoggerFactory.getLogger(MyThread.class);
    @Override
    public void run() {
        int seconds = 2;
        logger.info("START MyThread seconds: {}",seconds);

        try{Thread.sleep(1000*seconds); }catch (InterruptedException e){e.printStackTrace();}

        //descomentar para ver el ejemplo de concurrencia
       /*for (int i = 0; i < 1000000; i++) {
            Main.increment("MyThread");
        }*/

        logger.info("END MyThread");
    }
}


class MyRunnable implements Runnable{
    private final Logger logger = LoggerFactory.getLogger(MyRunnable.class);
    @Override
    public void run() {
        int seconds = 5;
        logger.info("START MyRunnable   seconds: {}",seconds);

        try{Thread.sleep(1000 * seconds); }catch (InterruptedException e){e.printStackTrace();}

        //descomentar para ver el ejemplo de concurrencia
        /*for (int i = 0; i < 1000000; i++) {
            Main.increment("MyRunnable");
        }*/

        logger.info("END MyRunnable");
    }
}