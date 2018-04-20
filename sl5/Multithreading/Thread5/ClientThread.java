
import java.io.*;
import java.net.*;
import java.lang.*;	

public class ClientThread implements Runnable {

    private Socket s;
    public ClientThread(Socket _s) {
   	 this.s = _s;
    }

    @Override
    public void run() {
   	 // TODO Auto-generated method stub
   	 try {
   		 DataInputStream din = new DataInputStream(s.getInputStream());
   		 DataOutputStream dout = new DataOutputStream(s.getOutputStream());

   		 int n1=1,n2;
   		 String client_id = din.readUTF();
   		 System.out.println("Client " + client_id + " connected");

   		 while (n1!=0) {
   			 n1 = din.read();
			 //n2 = din.read();
			 Double d1= new Double(n1);
			 //Double d2= new Double(n2);
                         Double feet=d1*3.14/180;
   			 //System.out.println("\nClient " + client_id +" says: " + n1);
 			 //System.out.println("\nClient " + client_id +" says: " + n2);
			 //double n3 = Math.pow(n1,n2);
   			 
		         String s=Double.toString(feet);		
			
			 System.out.println("\nAnswer " + s);
			 dout.writeUTF(s);
   			 dout.flush();
   		 }
   		 din.close();
   		 dout.close();
   		 s.close();

   	 } catch (IOException e) {System.out.print(e);}

    }

}
