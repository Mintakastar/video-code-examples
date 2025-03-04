package dev.raffenio.threads.how.to;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainLambdaExample {
    private static final Logger logger = LoggerFactory.getLogger(MainLambdaExample.class);
    public static void main(String[] args) {
        logger.info("START MainLambdaExample");

        Thread myLambdaThread = new Thread(() -> {
            logger.info("START myLambdaThread");

            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            logger.info("END myLambdaThread");
        },"myLambdaThread");


        myLambdaThread.start();

        logger.info("END MainLambdaExample");
    }
}