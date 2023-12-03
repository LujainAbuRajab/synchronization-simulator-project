/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import static java.lang.Math.random;
import java.lang.Thread;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class OS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //initiate the producer,consumer counter     
        int ConCounter = 0;
        int ProCounter = 0;
        
        //initiate Concumer and Producer Random for threads number
        Random random = new Random();
        int randomNumThPro = random.nextInt(10)+1;
        int randomNumThCun = random.nextInt(15)+1;

        //
        Random random1 = new Random();
        int randomNumPro = random1.nextInt(900)+100;
        int randomNumCun = random1.nextInt(901) + 100;

        for(int i=0;i<randomNumThCun;i++){
            consumer MyConsumer = new consumer();
            for(int j=1;j<randomNumCun;j++){
                MyConsumer.run();
                ConCounter++; 
            }
        }

        for(int i=0;i<randomNumThPro;i++){
           produser MyProducer = new produser();
           for(int j=1;j<randomNumPro;j++){
                MyProducer.run(); 
                ProCounter++;
           }
        } 
        int activeThreadCount = Thread.activeCount();
        System.out.println("Number of active threads: " + activeThreadCount);
        System.out.println("the final value of x is: "+Data.x);
        System.out.println("the correct final value of x is: "+(1000+ProCounter-ConCounter));
    }
    
}
