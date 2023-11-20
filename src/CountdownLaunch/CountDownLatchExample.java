package CountdownLaunch;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 3;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            Thread workerThread = new WorkerThread(latch, i);
            workerThread.start();
        }

        // 等待所有线程完成
        latch.await();
        System.out.println("所有线程都已完成，继续执行主线程");
    }
}

class WorkerThread extends Thread {
    private final CountDownLatch latch;
    private final int id;

    public WorkerThread(CountDownLatch latch, int id) {
        this.latch = latch;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("线程 " + id + " 正在执行");
        // 模拟工作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程 " + id + " 执行完成");
        latch.countDown(); // 减少计数器
    }
}
