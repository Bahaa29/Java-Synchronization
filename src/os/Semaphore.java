package os;

import java.io.IOException;

public class Semaphore
{
    public static int WIFI_Connection;

    String line3;
    public Main object3;
    //constructors
    Semaphore(int number)
    {
        WIFI_Connection=number;
    }
    public synchronized void P(Device device) throws IOException
    {
        WIFI_Connection--;
        if(WIFI_Connection<0)
        {
            try {
                System.out.println(device.getName()+" <["+device.DeviceType+"]> arrived and waiting");
                object3.write_file(device.getName() + " <["+device.DeviceType+"]> arrived and waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println(device.getName()+" <["+device.DeviceType+"]> arrived");
            object3.write_file(device.getName() + " <["+device.DeviceType+"]> arrived");
        }
    }
    public synchronized void V() {
        WIFI_Connection++;
        if (WIFI_Connection <= 0)
            notify();
    }
}

