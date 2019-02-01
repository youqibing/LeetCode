package MultiThread.AlternatelyPrint.PrintThree;


/**
 * 交替打印三个字符ABC，顺序输出固定次数，假设为10次
 */
public class AlternatelyPrintThree {

    public static void main(String args[]){
        BlockingQueueOutput out = new BlockingQueueOutput();

        ThreadA a=new ThreadA(out);
        ThreadB b=new ThreadB(out);
        ThreadC c=new ThreadC(out);

        a.start();
        b.start();
        c.start();

    }

    public static class ThreadA extends Thread{

        BlockingQueueOutput blockingQueueOutput;

        public ThreadA(BlockingQueueOutput bq){
            blockingQueueOutput = bq;
        }

        @Override
        public void run() {
            super.run();
            for (int i=0; i<10; i++) {
               blockingQueueOutput.printA(i);
            }
        }
    }

    public static class ThreadB extends Thread{

        BlockingQueueOutput blockingQueueOutput;

        public ThreadB(BlockingQueueOutput bq){
            blockingQueueOutput = bq;
        }

        @Override
        public void run() {
            super.run();
            for (int i=0; i<10; i++) {
                blockingQueueOutput.printB();
            }
        }

    }

    public static class ThreadC extends Thread{

        BlockingQueueOutput blockingQueueOutput;

        public ThreadC(BlockingQueueOutput bq){
            blockingQueueOutput = bq;
        }

        @Override
        public void run() {
            super.run();
            for (int i=0; i<10; i++) {
                blockingQueueOutput.printC();
            }
        }

    }


}
