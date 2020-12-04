package os;

public class Router {
    private int ConnectionsNo;
    private Boolean[] ConnectionsArr;
    private Semaphore semaphore;

    Router(int x){
        ConnectionsNo = x;
        ConnectionsArr = new Boolean[x];
        semaphore = new Semaphore(x);
    }
    public synchronized int Occupy(Device device){
        for(int i=0;i<ConnectionsNo;i++){
            if(ConnectionsArr[i] == false)
                break;
        }
    }
}
