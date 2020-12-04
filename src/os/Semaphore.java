package os;

public class Semaphore
{
    public static int WIFI_Connection;
    //constructors
    Semaphore(int number)
    {
        WIFI_Connection=number;
    }
    public synchronized void P(Device device)
    {
        WIFI_Connection--;
        if(WIFI_Connection<0)
        {
            try {
                System.out.println(device.getName() + " arrived and waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println(device.getName() + " arrived");
        }
    }
    public synchronized void V() {
        WIFI_Connection++;
        if (WIFI_Connection <= 0)
            notify();
    }
}

