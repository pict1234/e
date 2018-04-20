import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class ClientThread implements Runnable{

	Socket clientSocket;
	int numOfConnetions;
	BufferedReader bufferedReader;
	PrintStream printStream;
	
	public ClientThread(Socket clientSocket, int numOfConnetions) throws IOException {
		this.clientSocket = clientSocket;
		this.numOfConnetions = numOfConnetions;
		bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		printStream = new PrintStream(clientSocket.getOutputStream());
		System.out.println("Connection " + numOfConnetions + " established with " + clientSocket);
	}

	public void run() {
		String input = "";
		while(true){
			try {
				input = bufferedReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Recieved " + input + " from Connection " + numOfConnetions + ".");
			if(input.equals("stop"))	break;
			printStream.println("Server Echos :: " + input);
		}
		System.out.println( "Connection " + numOfConnetions + " closed." );
		try {
			bufferedReader.close();
			printStream.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
