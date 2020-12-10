package os;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Router
{
    public int ConnectionsNo; //
    public Boolean[] ConnectionsArr;
    public Semaphore semaphore;
    public int NumOfConnection;
    String line2;

    public Main object1;

    Router(int x)
    {
        ConnectionsNo = x;
        ConnectionsArr = new Boolean[x];
        for(int i=0;i<x;i++)
        {
            ConnectionsArr[i]=false;
        }
        semaphore = new Semaphore(x);
    }
    public synchronized int Occupy(Device device) throws InterruptedException, IOException
    {
        for(int i=0;i<ConnectionsNo;i++)
        {
            if(ConnectionsArr[i] == false)
            {
                NumOfConnection++;
                device.ConnectorId=i+1; //here i put the value of my connector it like id
                System.out.println("connection "+ device.ConnectorId+": "+device.getName()+" "+"occupied");
                line2="connection "+ device.ConnectorId+": "+device.getName()+" "+"occupied";
                object1.write_file(line2);
                ConnectionsArr[i]=true;
                sleep(1000);
                break;
            }

        }
        return device.ConnectorId;
    }
    public  String perform(Device device)
    {
        String temp = null;
        try {
            temp="performs online activity";
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return temp;
    }
    public synchronized String release(Device device) throws InterruptedException, IOException {
        NumOfConnection--;
        ConnectionsArr[device.ConnectorId-1]=false;
        sleep(1000);
        return "Logged Out";

    }
}
