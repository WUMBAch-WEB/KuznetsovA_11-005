package ThirdTask;

import java.util.Iterator;

public class Fibonacci implements Iterable<Integer> {
    final int length;
    public Fibonacci (int length){
        this.length = length;
    }
    private int previous = 0;
    int counter = 1;
    public Iterator iterator(){
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return counter < length;
            }

            @Override
            public Object next() {
                int t = counter;
                counter += previous;
                previous = t;
                return counter;
            }
        };
    }

}
