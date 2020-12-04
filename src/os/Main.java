package os;

import javax.naming.Name;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args)
    {
        Vector<String> Devices_List=new Vector<>();
        Network network=new Network();
        Scanner input=new Scanner(System.in);
        System.out.println("what is the number of wifi connections");
        int connection=input.nextInt();

        Router router=new Router(connection);
        network.setConnectionNo(connection);

        System.out.println("what is the number of devices Clients want to connect");
        int NumOfDevice=input.nextInt();

        int TC=NumOfDevice-connection;
        network.setWishesDevice(TC);

        Device[] device=new Device[NumOfDevice];
        System.out.println("what is device's Name");
        input=new Scanner(System.in);
        for (int i=0;i<NumOfDevice;i++)
        {
            String name=input.nextLine();
            Devices_List.add(name);
            device[i]=new Device(name,router);
        }
        network.setDevices_List(Devices_List);  
        for (int i=0;i<NumOfDevice;i++)
        {
            device[i].start();
        }

    }
}
