import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
        Socket clientSocket = serverSocket.accept(); // ждем подключения
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("New connection accepted");

        out.println("Please, write your name: ");
        final String name = in.readLine();
        out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

        out.println("Are you child? (yes/no)");
        String resp;
        while(!((resp = in.readLine()).equals("yes") || resp.equals("no"))){
            out.println("Sorry, I didn't understand your answer.");
            out.println("Are you child? (yes/no)");
        }
        if(resp.equals("yes")){
            out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
        }
        else{
            out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
        }
    }
}
