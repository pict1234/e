//RMIClient
import java.sql.*;
import java.rmi.*;
import java.io.*;
import java.util.*;
import java.util.Vector.*;
import java.lang.*;
import java.rmi.registry.*;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

public class Client {
	static String str1, str2, revString;

	public static void main(String args[])
	{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		int ch;
		try
		{
			Registry r1 = LocateRegistry.getRegistry ("localhost", 1030);
			DBInterface DI=(DBInterface)r1.lookup("Service");
			
			do
			{
				System.out.println("\n1.Send input stings\n2.Display result\n3.Exit\nEnter ur choice::");
				ch=Integer.parseInt(b.readLine());
				switch(ch)
				{
					case 1:
						System.out.println(" \nEnter first string:");
						str1=b.readLine();
						System.out.println(" \nEnter second string:");
						str2=b.readLine();
						revString=DI.input(str1.toLowerCase(),str2.toLowerCase());
						break;
					case 2:
						//display
						System.out.println("\nResult is : ");
						System.out.println(" " +revString+"");
						break;
					case 3:
						System.out.println("Client Connection Terminated!!");
						return;
				}
			}while(ch>0);
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " +e.getMessage());
		}
	}
}
