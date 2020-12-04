package os;

public class Device extends Thread
{
    public int ConnectorId ;
    public Router object;
    Device(String clientName, Router router)
    {
        super(clientName);
        object = router;
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

        System.out.println("connection "+ConnectorId+": "+this.getName()+" "+object.release(this));
        object.semaphore.V();

    }
}
