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
	String name3;
	ResultSet r;
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
			java.rmi.registry.LocateRegistry.createRegistry(2025).rebind("DBServ", rs);
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " +e.getMessage());
		}
	}
	public String input(String name1,String name2)
	{
		try{
			if(name1.toLowerCase().contains(name2.toLowerCase()))
			{
				name3="TRUE : String is Substring";
			}
			else
			{
				name3="FALSE : string is not substring";
			}

		}
		catch (Exception e)
		{
			System.out.println("ERROR: " +e.getMessage());
		}
		return name3;
	}

}
