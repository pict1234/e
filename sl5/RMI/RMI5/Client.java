//RMIClient//
import java.sql.*;
import java.rmi.*;
import java.io.*;
import java.util.*;
import java.util.Vector.*;
import java.lang.*;
import java.rmi.registry.*;
public class Client
{
	static int n1,n2,n3;
	public static void main(String args[])
	{
		Client c=new Client();
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		int ch;
		try {
			Registry r1 = LocateRegistry.getRegistry ( "localhost", 1030);
			DBInterface DI=(DBInterface)r1.lookup("DBServ");
			do
			{
				System.out.println("1.send input integer\n2.Display raise to \nEnter ur choice");
				ch= Integer.parseInt(b.readLine());
				switch(ch)
				{
					case 1:
						System.out.println(" \n Enter first no1:");
						n1=Integer.parseInt(b.readLine());
						System.out.println(" \n Enter second no2:");
						n2=Integer.parseInt(b.readLine());
						n3=DI.input(n1,n2);
						break;
					case 2:
						//display
						System.out.println("\n raise to : ");
						//int i=0;
						System.out.println(" " +n3+"");
						break;
				}
			}while(ch>0);
		}
		catch (Exception e)
		{
			// System.out.println("ERROR: " +e.getMessage());
		}
	}
}
