import java.net.*;
import java.io.*;

public class Server
{
    static ServerSocket ss = null;
    public static void main(String[] args)
    {

   	 System.out.println("\nServer is now running...");

   	 Runnable listen = new Runnable() {

   		 @Override
   		 public void run() {

   			 int i = 1;

   			 try {

   				 ss = new ServerSocket(3452);
   				 System.out.println("Listening at port 3452");

   				 while(true) {
   					 Socket s = ss.accept();
   					 if(s != null && i <= 10) {
   						 System.out.println("\nCreating thread number " + i);
   						 i++;
   						 new Thread(new ClientThread(s)).start();
   					 }
   					 else
   						 break;
   				 }

   				 ss.close();

   			 }catch(Exception e) {System.out.print(e);}
   		 }
   	 };
   	 new Thread(listen).start();
    }
}
