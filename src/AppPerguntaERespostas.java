import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AppPerguntaERespostas {

    public static void main (String[] args) throws IOException {

        // Abrindo Socket

        ServerSocket Servidor = new ServerSocket(4242); // Definido a porta 4242 TCP.
        System.out.println("Servidor Iniciado...");
        Socket Inputclient = Servidor.accept();
        System.out.println("Conexão Estabelecida. " + Inputclient.getInetAddress().getHostAddress()); // Apresenta IP e Host.


        // Recebendo Nome dos Jogadores

        Scanner entrada = new Scanner(System.in);
        Players player = new Players();

        System.out.println("Informe o nome do Player 1: ");
        player.setPlayer1(entrada.next());

        System.out.println("Informe o nome do Player 2: ");
        player.setPlayer2(entrada.next());

        player.NamePlayers();
    }
}
