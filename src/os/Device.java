package os;

import java.io.IOException;

public class Device extends Thread
{
    String DeviceType;
    public int ConnectorId ;
    public Router object;
    String line3;

    public Main object2;

    Device(String DeviceName,String type, Router router)
    {
        super(DeviceName);
        DeviceType= type;
        object = router;
    }
    public String getType()
    {
        return DeviceType;
    }
    public void run()
    {
        try {
            object.semaphore.P(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ConnectorId=object.Occupy(this);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("connection "+ConnectorId+": "+this.getName()+" "+object.perform(this));
        try {
            object2.write_file("connection "+ConnectorId+": "+this.getName()+" "+object.perform(this));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            try {
                System.out.println("connection "+ConnectorId+": "+this.getName()+" "+object.release(this));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                object2.write_file("connection "+ConnectorId+": "+this.getName()+" "+object.release(this));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        object.semaphore.V();

    }
}
