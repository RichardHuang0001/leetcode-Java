package 栈;

import java.util.List;
import java.util.PriorityQueue;

import java.util.PriorityQueue;

class MedianFinder {
    // 大顶堆（保存较小的一半）
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    // 小顶堆（保存较大的一半）
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MedianFinder() {}

    public void addNum(int num) {
        // 步骤1：判断放入哪个堆
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // 步骤2：调整平衡
        // 如果 maxHeap 比 minHeap 多超过1个元素
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        // 如果 minHeap 比 maxHeap 多元素（理论上不会发生，但为了安全）
        else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // maxHeap 的 size 比 minHeap 多1，直接返回 maxHeap 的堆顶
            return maxHeap.peek();
        }
    }
}