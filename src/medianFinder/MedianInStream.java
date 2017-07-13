package medianFinder;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianInStream {
    // max queue is always larger or equal to min queue
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.add(num);
        min.add(max.remove());
        if (max.size() < min.size()){
            max.add(min.remove());
        }
        System.out.println("**** ");
        System.out.print("MIN :" );System.out.println(min);
        System.out.print("MAX :" ); System.out.println(max);
        System.out.println(findMedian());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        else return max.peek();
    }
    
    public static void main(String[] args) {
		MedianInStream m = new MedianInStream();
		m.addNum(5);
		m.addNum(15);
		m.addNum(1);
		m.addNum(3);
	}
}