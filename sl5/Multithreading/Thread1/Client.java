import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket clientSocket = null;
		DataOutputStream dataOutputStream = null;
		BufferedReader bufferedReaderInputStream = null;

		clientSocket = new Socket("localhost", 6789);
		dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		bufferedReaderInputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		while (true) {
			System.out.print("Enter an msg (stop to stop connection) :: ");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String input = bufferedReader.readLine();
			dataOutputStream.writeBytes(input + "\n");
			if (input.equals("stop"))	break;
			String responseLine = bufferedReaderInputStream.readLine();
			System.out.println("Server returns :: "	+ responseLine);
		}

		dataOutputStream.close();
		bufferedReaderInputStream.close();
		clientSocket.close();

	}
}
