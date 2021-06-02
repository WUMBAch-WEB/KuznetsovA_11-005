package FirstTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++){
            Writer.MyThread writerThread = new Writer.MyThread();
            Reader.MyThread readerThread = new Reader.MyThread();
            writerThread.start();
            writerThread.join();
            readerThread.start();
            readerThread.join();
        }
    }
}
