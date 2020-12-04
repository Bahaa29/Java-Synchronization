package os;

public class Device extends Thread
{
    public Router object;
    Device(String clientName, Router router)
    {
        super(clientName);
        object = router;
    }
}
