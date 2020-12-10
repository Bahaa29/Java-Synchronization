package os;

import javax.naming.Name;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void write_file(String line) throws IOException {
        FileWriter myWriter = new FileWriter("filename.txt",true);
        myWriter.write(line);
        myWriter.write(System.lineSeparator());

        myWriter.close();
    }
    public static void main(String[] args) throws IOException
    {
        PrintWriter pw = new PrintWriter("filename.txt");
        pw.close();
        String line1;
        Vector<String> Devices_List=new Vector<>();
        Network network=new Network();
        Scanner input=new Scanner(System.in);
        System.out.println("what is the number of wifi connections");
        line1="what is the number of wifi connections";
        write_file(line1);

        int connection=input.nextInt();

        line1 =String.valueOf(connection);
        write_file(line1);

        Router router=new Router(connection);
        network.setConnectionNo(connection);

        System.out.println("what is the number of devices Clients want to connect");

        line1="what is the number of devices Clients want to connect";
        write_file(line1);

        int NumOfDevice=input.nextInt();
        input=new Scanner(System.in);
        line1 =String.valueOf(NumOfDevice);
        write_file(line1);
        int TC=NumOfDevice-connection;
        network.setWishesDevice(TC);

        Device[] device=new Device[NumOfDevice];

        for (int i=0;i<NumOfDevice;i++)
        {
            System.out.println("what is the name of device:"+""+(i+1));
            line1="what is the name of device:";
            write_file(line1);
            String name=input.nextLine();
            write_file(name);

            System.out.println("what is the type of device:"+""+(i+1));
            line1="what is the type of device:";
            write_file(line1);
            String type=input.nextLine();
            write_file(type);


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
