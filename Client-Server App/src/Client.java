import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try(Socket clientSocket = new Socket("netology.homework", 8080);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            String request;
            while((request = in.readLine()) != null){
                System.out.println(request);
                String msg = scanner.nextLine();
                out.println(msg);
                String resp = in.readLine();
                System.out.println(resp);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}