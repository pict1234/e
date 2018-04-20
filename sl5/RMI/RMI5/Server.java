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
	public int input(int n1,int n2) throws RemoteException;
}
public class Server extends UnicastRemoteObject implements DBInterface
{
	int flag=0,n,i,j;
	int res=1;
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
	public int input(int n1,int n2)
	{
		try
		 {
		   //int res=1;
		   for(int i=1;i<=n2;i++)
			res*=n2;
		    //return res;
		 }
		catch (Exception e)
		 {
		  System.out.println("ERROR: " +e.getMessage());
		 }
		return res;
	}
}
