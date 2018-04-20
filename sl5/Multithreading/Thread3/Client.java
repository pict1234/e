import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws Exception{

   	 Socket s = new Socket("localhost", 3452);
   	 Random rand = new Random();
   	 Integer client_id = rand.nextInt(100);
   	 DataInputStream din = new DataInputStream(s.getInputStream());
   	 DataOutputStream dout = new DataOutputStream(s.getOutputStream());
   	 Scanner scan = new Scanner(System.in);
   	 int n1=1,n2;
	 String d3="";
   	 dout.flush();
   	 dout.writeUTF(client_id.toString());
   	 dout.flush();
   	 while(n1!=0)
   	 {
   		 System.out.println("\nEnter 2 nos: ");
   		 n1 = scan.nextInt();
   		 n2 = scan.nextInt();
		 dout.write(n1);
		 dout.write(n2);
   		 dout.flush();
		 d3=din.readUTF();
		 System.out.println("\nOutput is "+d3);
		 dout.flush();
   		  		 
   	 }

   	 din.close();
   	 dout.close();
   	 s.close();
   	 scan.close();
    }
}
