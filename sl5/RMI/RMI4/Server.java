//RMI Server //
import java.sql.*;
import java.sql.Connection;
import java.rmi.*;
import java.rmi.Naming.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.Vector;

interface DBInterface extends Remote
{
	public String input(String name1,String name2) throws RemoteException;
}
public class Server extends UnicastRemoteObject implements DBInterface
{
	int flag=0,n,i,j;
	//String name3;
	//ResultSet r;
	public Server() throws RemoteException
	{ 
		try
		{ 
		  System.out.println("Initializing Server\nServer Ready");
		}
		catch (Exception e)
		{ 
		  System.out.println("ERROR: " +e.getMessage());
		}
	}
	public static void main(String[] args)
	{
		 try
		 {
		  Server rs=new Server();
	 	  java.rmi.registry.LocateRegistry.createRegistry(1030).rebind("DBServ",rs);
		 }
		 catch (Exception e)
		 {
		  System.out.println("ERROR: " +e.getMessage());
		 }
	}
	public String input(String name1,String name2)
	{
		try
		 {
		  char ch;
		int cnt1 = 0,cnt2 = 0;
		for(int i=0;i<name1.length();i++)
		{
			ch = name1.charAt(i);
			if(ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
				cnt1++;
		}
		
		for(int i=0;i<name2.length();i++)
		{
			ch = name2.charAt(i);
			if(ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
				cnt2++;
		}
		
		if(cnt1 == cnt2)
		{
			return name1+" and "+name2+" contains same number of Vowels.";
		}
		else
		{
			return name1+" and "+name2+" DO NOT contains of same number of Vowels.";		
		}

		 }
		catch (Exception e)
		 {
		  System.out.println("ERROR: " +e.getMessage());
		 }
		//return name3;
	}
}
