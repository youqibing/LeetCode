package MultiThread.AlternatelyPrint.PrintThree;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueOutput {

    public BlockingQueue<Integer> bqA=new ArrayBlockingQueue<>(1);
    public BlockingQueue<Integer>bqB=new ArrayBlockingQueue<>(1);
    public BlockingQueue<Integer>bqC=new ArrayBlockingQueue<>(1);


    BlockingQueueOutput(){
        try {
            bqB.put(1);
            bqC.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void printA(int i){

        try {
            bqA.put(1);
            System.out.println(" ");
            System.out.println("第"+i+"次：");
            System.out.print("A");
            bqB.take();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void printB(){

        try {
            bqB.put(1);
            System.out.print("B");
            bqC.take();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    public void printC(){

        try {
            bqC.put(1);
            System.out.print("C");
            bqA.take();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
