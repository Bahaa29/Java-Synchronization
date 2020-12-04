package os;

import java.util.Vector;

public class Network {
    private int ConnectionNo;
    private int WaitingListLimit;
    private Vector<String> Devices_List;
    //Getters
    public int getConnectionNo() {
        return ConnectionNo;
    }
    public void setConnectionNo(int connectionNo) {
        ConnectionNo = connectionNo;
    }
    public int getWaitingListLimit() {
        return WaitingListLimit;
    }
    //Setters
    public void setWaitingListLimit(int waitingListLimit) {
        WaitingListLimit = waitingListLimit;
    }
    public Vector<String> getDevices_List() {
        return Devices_List;
    }
    public void setDevices_List(Vector<String> devices_List) {
        Devices_List = devices_List;
    }
}
