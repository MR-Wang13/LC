package ng.tiktok.vo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> smallQueue;
    PriorityQueue<Integer> bigQueue;

    public MedianFinder() {
        smallQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 大顶堆
        bigQueue = new PriorityQueue<>(); // 小顶堆
    }

    public void addNum(int num) {
        // 首次插入，放入 smallQueue
        if (smallQueue.size() == 0 && bigQueue.size() == 0) {
            smallQueue.offer(num);
            return;
        }

        // 根据当前值插入合适的堆
        if (num <= smallQueue.peek()) {
            smallQueue.offer(num);
        } else {
            bigQueue.offer(num);
        }

        // 保持两个堆的平衡
        balanceHeaps();
    }

    public void remove(int num) {
        // 根据 num 判断在哪个堆中，然后尝试移除
        if (smallQueue.contains(num)) {
            smallQueue.remove(num);
        } else if (bigQueue.contains(num)) {
            bigQueue.remove(num);
        }

        // 保持两个堆的平衡
        balanceHeaps();
    }

    public double findMedian() {
        // 若堆都为空
        if (smallQueue.size() == 0 && bigQueue.size() == 0) {
            return -1;
        }

        // 如果两个堆大小相等，返回两堆顶元素的平均值
        if (smallQueue.size() == bigQueue.size()) {
            return (smallQueue.peek() + bigQueue.peek()) / 2.0;
        } else {
            return smallQueue.peek();
        }
    }

    // 平衡两个堆的大小
    private void balanceHeaps() {
        if (smallQueue.size() > bigQueue.size() + 1) {
            bigQueue.offer(smallQueue.poll());
        } else if (bigQueue.size() > smallQueue.size()) {
            smallQueue.offer(bigQueue.poll());
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian()); // 输出：1.5
        finder.addNum(3);
        System.out.println(finder.findMedian()); // 输出：2.0

        // 测试 remove 方法
        finder.remove(2);
        System.out.println(finder.findMedian()); // 输出：2.0（因为 2 被删除了，堆重新平衡）
    }
}
