package JavaBasicKnowledge;


import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args){
        /**
         * 创建线程池的固定形式 "ExecutorService","Executors"这是两个类，之后还有一个 "Executor"接口
         */
        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorService exe = Executors.newCachedThreadPool();

        futureTaks(executor);
        future(exe);
        thread();
    }

    private static void futureTaks(ExecutorService executor){

        /**
         * FutureTask是一个实现了类, 因此可以实例化, 其中一个构造方法参数为
         * "FutureTask(Callable<V> callable)" 因此可以直接执行 new Callable
         */
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("FutureTaks子线程："+Thread.currentThread().getName());
                Thread.sleep(1000);
                int sum = 0;
                for(int i=0;i<100;i++)
                    sum += i;
                return sum;
            }
        });

        /*
         * execute只能接受Runnable类型的任务，因此execute没有返回值
         * submit不管是Runnable还是Callable类型的任务都可以接受，因此submit有返回值，
         * 所以对于有返回值的futureTask需要用submit()来启动
         */
        executor.submit(futureTask);
        executor.shutdown();

        try {
            System.out.println(futureTask.get());   //futureTask.get()获取返回值
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    private static void future(ExecutorService executor){

        /**
         * Future是一个接口, 不能实例化, 直接调用executor.submit() 开始一个任务即可
         */
        Future<Integer> future = executor.submit(new Callable<Integer>() {  //future
            @Override
            public Integer call() throws Exception {
                System.out.println("Future子线程："+Thread.currentThread().getName());
                Thread.sleep(1000);
                int sum = 0;
                for(int i=0;i<50;i++)
                    sum += i;
                return sum;
            }
        });

        executor.shutdown();

        try {
            System.out.println(future.get());   //future.get()方法获取最终的返回值
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static void thread(){

        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("thread子线程："+Thread.currentThread().getName());
                Thread.sleep(1000);
                int sum = 0;
                for(int i=0;i<20;i++)
                    sum += i;
                return sum;
            }
        });

        /**
         * 这里主要说明, FutureTask+Callable只是创建一个有返回值的任务,因此也可以用Thread触发,只是Tread是单线程,不适合高并发的场景
         * 另外不能用 Thread直接触发 Callable接口，因为Thread构造函数参数应当是 Runnable接口,而FutureTask
         * 继承自RunnableFuture,RunnableFuture继承自Runnable, Future<V>
         */
        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
