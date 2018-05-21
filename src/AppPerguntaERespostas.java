import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AppPerguntaERespostas {

    public static void main (String[] args) throws IOException {

        // Abrindo Socket

        ServerSocket Servidor = new ServerSocket(4242); // Definido a porta 4242 TCP.
        System.out.println("Servidor Iniciado...");
        Socket Cliente = Servidor.accept(); // Permite conexão.
        System.out.println("Conexão Estabelecida com: " + Cliente.getInetAddress().getHostAddress()); // Apresenta IP e Host.
        Scanner Input = new Scanner(Cliente.getInputStream()); // Recebendo dados da maquina 2 via Socket.
        PrintWriter Output = new PrintWriter(Cliente.getOutputStream()); // Enviando dados para maquina 1 via Socket.

        // Recebendo Nome Player 1 Local

        Scanner entrada = new Scanner(System.in); // Inicializa a entrada de dados via Teclado.
        Players player = new Players();
        //Words words = new Words();

        System.out.println("Informe o nome do Player 1: ");
        player.setPlayer1(entrada.next()); // Armazenando nome de Player 1.
        player.setPlayer2(Input.nextLine());   // Armazenando nome de Player 2.

        // Comentário

        //Output.println(player.getPlayer1());


        player.NamePlayers();
        //words.Saida();

    }
}
