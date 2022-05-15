package Task3;

public class Main {
    public static void main(String[] args) {
        Priority mt1 = new Priority("High priority thread");
        Priority mt2 = new Priority("Thread with low priority");
        Priority mt3 = new Priority("Thread # 1 with normal priority");
        Priority mt4 = new Priority("Thread # 2 with normal priority");
        Priority mt5 = new Priority("Thread # 3 with normal priority");

        mt1.thread.setPriority(Thread.MAX_PRIORITY );
        mt2.thread.setPriority(Thread.MIN_PRIORITY);

        mt1.thread.start();
        mt2.thread.start();
        mt3.thread.start();
        mt4.thread.start();
        mt5.thread.start();

        try{
            mt1.thread.join();
            mt2.thread.join();
            mt3.thread.join();
            mt4.thread.join();
            mt5.thread.join();
        }catch (InterruptedException e){
            System.out.println("The main thread starts running");
        }
        System.out.println("\nHigh priority thread counted to " + mt1.count);
        System.out.println("The low priority thread added to " + mt2.count);
        System.out.println("# 1 Normal priority thread added to " + mt3.count);
        System.out.println("# 2 Normal priority thread added to " + mt4.count);
        System.out.println("# 3 Normal priority thread added to " + mt5.count);

    }
}
