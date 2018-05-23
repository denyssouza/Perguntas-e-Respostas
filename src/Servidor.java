import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Servidor {

    public static void main (String[] args) throws IOException {

        // Abrindo Socket

        ServerSocket Servidor = new ServerSocket(4242); // Definido a porta 4242 TCP.
        System.out.println("Servidor Iniciado...");
        Socket Cliente = Servidor.accept(); // Permite conexão.
        System.out.println("Conexão Estabelecida com: " + Cliente.getInetAddress().getHostAddress()); // Apresenta IP e Host.


        BufferedReader Input = new BufferedReader(new InputStreamReader(Cliente.getInputStream())); // Recebendo dados da maquina 2 via Socket.
        PrintStream Output = new PrintStream(Cliente.getOutputStream()); // Enviando dados para maquina 1 via Socket.

        // Recebendo Nome Player 1 Local

        Scanner entrada = new Scanner(System.in); // Inicializa a entrada de dados via Teclado.
        Players player = new Players();

        System.out.println("Informe o nome do Player 1: ");
        player.setPlayer1(entrada.next()); // Armazenando nome de Player 1.
        player.setPlayer2(Input.readLine());   // Armazenando nome de Player 2.

        // Comentário

        Output.println(player.NamePlayers()); // Imprime para Cliente.
        System.out.println(player.NamePlayers()); // Imprime para Servidor.


    }
}