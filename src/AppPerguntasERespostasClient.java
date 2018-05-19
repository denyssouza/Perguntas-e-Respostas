import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AppPerguntasERespostasClient {

    public static void main(String[] args) throws UnknownHostException, IOException{

        // Realizando Conexão com Servidor.

        Socket OutServidor = new Socket("127.0.0.1", 4242); // Conectando ao IP localHost:4242
        System.out.println("Conexão Estabelecida.");

        // Enviando nome do Player 2 via Socket

        System.out.println("Informe o nome do Player 2: ");
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(OutServidor.getOutputStream());
        saida.println(teclado.nextLine());

        // Comentário

        //ObjectInputStream entrada = new ObjectInputStream(OutServidor.getInputStream());
        //Scanner s = new Scanner(OutServidor.getInputStream());
        //System.out.println(s.nextLine());


    }
}
