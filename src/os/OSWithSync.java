/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import static java.lang.Math.random;
import java.lang.Thread;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class OSWithSync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //initiate the producer,consumer counter        
        int ConCounter = 0;
        int ProCounter = 0;
         
        Random random = new Random();
        int randomNumThPro = random.nextInt(10)+1;
        int randomNumThCun = random.nextInt(15)+1;

        Random random1 = new Random();
        int randomNumPro = random1.nextInt(900)+100;
        int randomNumCun = random1.nextInt(900) + 100;
        
        Semaphore semaphore = new Semaphore(15);
        
        int BUFFER_SIZE = 800;
        Semaphore full = new Semaphore(1000);//emaphore to track the number of full slots
        Semaphore empty = new Semaphore(BUFFER_SIZE);
        int[] buffer = new int[BUFFER_SIZE];
        
        for(int i=0;i<randomNumThPro;i++){
           produser MyProducer = new produser();
           for(int j=1;j<randomNumPro;j++){
               try {
                   if(ProCounter==800){
                       System.out.println("the value of buffer is reach to 1799 and make infinte loop");
                   }
                   
                   empty.acquire();
                   semaphore.acquire(); 
               } catch (InterruptedException ex) {
                   Logger.getLogger(OSWithSync.class.getName()).log(Level.SEVERE, null, ex);
               }
                MyProducer.run(); 
                ProCounter++;
                int item = i;
                buffer[i % BUFFER_SIZE] = item;
                semaphore.release();
                full.release();
           }
        } 
              
        for(int i = 0; i < randomNumThCun ; i++){
            consumer MyConsumer = new consumer();
            for(int j=1;j<randomNumCun;j++){
                try {
                   if(ConCounter==1000){
                       System.out.println("the value of buffer is reach to 0 and make infinte loop");
                   } 
                    full.acquire();
                    semaphore.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(OSWithSync.class.getName()).log(Level.SEVERE, null, ex);
                }
                MyConsumer.run();
                int item = buffer[i % BUFFER_SIZE];
                ConCounter++;
                semaphore.release();
                empty.release();
            }
        }
        

        System.out.println("the final value of x with sync is: "+Data.x);

    }
    
}
