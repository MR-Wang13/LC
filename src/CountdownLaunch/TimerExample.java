package CountdownLaunch;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new MyTask(); // 替换MyTask为您自定义的任务
        long delayInMillis = 1000; // 1000毫秒（1秒）

        timer.schedule(task, delayInMillis);

    }
}
class MyTask extends TimerTask {
    @Override
    public void run() {
        // 任务运行时要执行的代码
        System.out.println("任务执行了！");
    }
}
