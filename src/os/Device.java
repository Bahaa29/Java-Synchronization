package os;

public class Device extends Thread
{
    String DeviceType;
    public int ConnectorId ;
    public Router object;
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
        object.semaphore.P(this);
        try {
            ConnectorId=object.Occupy(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("connection "+ConnectorId+": "+this.getName()+" "+object.perform(this));

        try {
            System.out.println("connection "+ConnectorId+": "+this.getName()+" "+object.release(this));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        object.semaphore.V();

    }
}
