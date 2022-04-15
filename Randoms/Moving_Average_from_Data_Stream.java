package Randoms;

import java.util.ArrayDeque;
import java.util.Queue;

public class Moving_Average_from_Data_Stream {

    private int maxSize = 0;
    private final Queue<Integer> queue;
    private long sum = 0;

    public Moving_Average_from_Data_Stream(int maxSize){
        this.maxSize = maxSize;
        queue = new ArrayDeque<>(maxSize+1);
    }

    public double main(int value){
        queue.add(value);
        sum += value;
        if(queue.size()>maxSize)
            sum -= queue.remove();

        return (double)sum / queue.size();
    }
}
