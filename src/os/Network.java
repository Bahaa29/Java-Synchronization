package os;

import java.util.Vector;

public class Network {
    private int ConnectionNo;
    private int TC;
    private Vector<String> Devices_List;

    //Getters
    public int getConnectionNo() {
        return ConnectionNo;
    }
    public void setConnectionNo(int connectionNo) {
        ConnectionNo = connectionNo;
    }
    public int setWishesDevice() {
        return TC;
    }
    //Setters
    public void setWishesDevice(int TC) {
        TC = this.TC;
    }
    public Vector<String> getDevices_List() {
        return Devices_List;
    }
    public void setDevices_List(Vector<String> devices_List) {
        Devices_List = devices_List;
    }
}
