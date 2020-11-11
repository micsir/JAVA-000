package thread.demo;

import java.util.concurrent.*;

/**
 * @author deepin
 */
public class RunThreadMain {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        Task<String> task = new Task<>();
        Thread taskThread = new Thread(task);
        taskThread.start();
        taskThread.join();
        System.out.println("task result:"+ task.getResult());

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> customCall = ()-> {
           return new Run().run();
        };
        Future customCallFuture= executorService.submit(customCall);
        executorService.shutdown();

        Object customCallResult = customCallFuture.get(400,TimeUnit.MILLISECONDS);
        System.out.println("customCall Task Result:"+ customCallResult);
    }

    public static class Task<T> implements Runnable {
        private T result;
        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("threadName:" +  Thread.currentThread().getName());
            result = (T)((System.currentTimeMillis() + ""));
        }

        public T getResult() {
            return result;
        }
    }
    public static  class  Run{
        public String run() {
            System.out.println("threadName:" +  Thread.currentThread().getName());
            return  (System.currentTimeMillis() + "");
        }
    }
}
