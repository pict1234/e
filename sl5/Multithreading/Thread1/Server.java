import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	
	static ServerSocket serverSocket = null;
	static Socket clientSocket;
	static int numOfConnetions = 0;
	
	public static void main(String args[]) throws IOException{
		
		serverSocket = new ServerSocket(6789);
		System.out.println("Server is now ready to accept connections");
		
		while(true){
			clientSocket = serverSocket.accept();
			numOfConnetions++;
			new Thread(new ClientThread(clientSocket, numOfConnetions)).start();
		}
	}
	
}