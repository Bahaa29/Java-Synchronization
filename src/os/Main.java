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
        input=new Scanner(System.in);
        int TC=NumOfDevice-connection;
        network.setWishesDevice(TC);

        Device[] device=new Device[NumOfDevice];

        for (int i=0;i<NumOfDevice;i++)
        {
            System.out.println("what is the name of device:"+""+(i+1));
            String name=input.nextLine();

            System.out.println("what is the type of device:"+""+(i+1));
            String type=input.nextLine();

            Devices_List.add(name);
            device[i]=new Device(name,type,router);
        }
        network.setDevices_List(Devices_List);
        for (int i=0;i<NumOfDevice;i++)
        {
            device[i].start();
        }

    }
}
