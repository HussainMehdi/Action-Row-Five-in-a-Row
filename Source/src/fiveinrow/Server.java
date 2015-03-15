

package fiveinrow;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Server {
    
       private static ServerSocket serverSocket;
	private static Socket clientSocket;
	private static BufferedReader bufferedReader;
	private static String inputLine;
        
        int[] GetMove() 
        {   int x[]={0,0};
            try
		{
			serverSocket = new ServerSocket(6300);
			clientSocket = serverSocket.accept();
			// Create a reader
			bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			// Get the client message
			
                        
                        inputLine = bufferedReader.readLine();
			Scanner Helpme= new Scanner(inputLine);
                        x[0]=Helpme.nextInt();
                        x[1]=Helpme.nextInt();
                        
                        serverSocket.close();
                        
                        
		}
		catch(IOException e)
		{
			System.out.println(e);
                        try{serverSocket.close();}
                        catch(Exception ex){}
		}
            return x;
        }
}
