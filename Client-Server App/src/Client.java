import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try(Socket clientSocket = new Socket("localhost", 8080);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            System.out.println("Please, input your name: ");
            String msg = scanner.nextLine();
            out.println(msg);
            String resp = in.readLine();
            System.out.println(resp);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}