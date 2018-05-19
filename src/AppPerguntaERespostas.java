import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AppPerguntaERespostas {

    public static void main (String[] args) throws IOException {

        // Abrindo Socket

        ServerSocket InputServidor = new ServerSocket(4242); // Definido a porta 4242 TCP.
        System.out.println("Servidor Iniciado...");
        Socket InputClient = InputServidor.accept();
        System.out.println("Conexão Estabelecida com: " + InputClient.getInetAddress().getHostAddress()); // Apresenta IP e Host.


        // Recebendo Nome Player 1 Local

        Scanner entrada = new Scanner(System.in);
        Players player = new Players();

        System.out.println("Informe o nome do Player 1: ");
        player.setPlayer1(entrada.next());

        // Recebendo Nome Player 2 Via Socket

        Scanner s = new Scanner(InputClient.getInputStream());
        player.setPlayer2(s.nextLine());

        // Comentário


        //PrintStream saida = new PrintStream(InputClient.getOutputStream());
        //Scanner teclado = new Scanner(System.in);
        //saida.println(teclado.nextLine());

        player.NamePlayers();
    }
}
