public class Task1 extends Thread implements Runnable
{
    Thread thread;
    Task1(String name)
    {
        thread=new Thread( this,name);
    }
    public static Task1 createAndStart(String name)
    {
        Task1 myThreadVer3 = new Task1(name);
        myThreadVer3.thread.start();
        return  myThreadVer3;
    }

    public void run()
    {
        System.out.println(thread.getName()+" Starts to operate ");
        try
        {
            for(int count=0;count<10;count++)
            {
                Thread.sleep(100);
                System.out.println(thread.getName()+" is executed, the counter value : "+ count);
            }
        }catch (InterruptedException e)
        {
            System.out.println(thread.getName()+" has been interrupted");
        }
        System.out.println(thread.getName()+ " finishes running.");
    }
}

class MoreThreads2{
    public static void main(String[] args)
    {
        System.out.println("The main thread starts running.");
        Task1 myThread1 = Task1.createAndStart("Child thread # 1");
        Task1 myThread2 = Task1.createAndStart("Child thread # 2");
        Task1 myThread3 = Task1.createAndStart("Child thread # 3");
        /*do {
            System.out.println(".");
            try{
                Thread.sleep(100);
            }catch (InterruptedException e)
            {
                System.out.println("The main has been terminated.");
            }
        }while (myThread1.thread.isAlive()||myThread2.thread.isAlive()||myThread3.thread.isAlive());*/
        try {
            myThread1.join();
            myThread2.join();
            myThread3.join();
        }catch (InterruptedException e)
        {
            System.out.println("The main has been terminated.");
        }
        System.out.println("The main thread is exiting");
    }
}