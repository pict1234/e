//RMI Server
import java.sql.*;
import java.sql.Connection;
import java.rmi.*;
import java.rmi.Naming.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.Vector;

interface DBInterface extends Remote {
	public String input(String name1, String name2) throws RemoteException;
}

public class Server extends UnicastRemoteObject implements DBInterface {
	int flag = 0, n, i, j;
	String reverse = "";
	String result;

	public Server() throws RemoteException {
		try {
			System.out.println("Initializing Server\nServer Ready");
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

	public static void main(String[] args){
		try
		{
			Server rs=new Server();
			java.rmi.registry.LocateRegistry.createRegistry(1030).rebind("Service", rs);
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " +e.getMessage());
		}
	}

	public String input(String str1, String str2) {
		try {
			for(int i = str1.length() - 1; i>=0; i--) {
				reverse =  reverse + str1.charAt(i);
			}
			if(reverse.equals(str2)) {
				result = "\nStrings are reverse of each other!\n";
			}
			else
				result = "\nStrings are not reverse of each other!\n";
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return result;
	}
}
