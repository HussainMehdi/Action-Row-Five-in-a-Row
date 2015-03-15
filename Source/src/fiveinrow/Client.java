
package fiveinrow;
import java.net.Socket;
import java.io.PrintWriter;

public class Client {
    private static Socket socket;
    private static PrintWriter printWriter;
    
    void SendMove(int[] Move)
    {
        try
		{
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Move[0]);
                    sb.append(" ");
                    sb.append(Move[1]);
                    String strI = sb.toString();
			socket = new Socket("localhost",6300);
			printWriter = new PrintWriter(socket.getOutputStream(),true);
			printWriter.println(strI);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
    }
}
