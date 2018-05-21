import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AppPerguntasERespostasClient {

    public static void main(String[] args) throws UnknownHostException, IOException{

        // Realizando Conexão com Servidor.

        Socket Servidor = new Socket("127.0.0.1", 4242); // Conectando ao IP 127.0.0.1:4242
        System.out.println("Conexão Estabelecida.");
        PrintStream Output = new PrintStream(Servidor.getOutputStream()); // Enviando dados para maquina 1 via Socket.
        InputStreamReader streamReader = new InputStreamReader(Servidor.getInputStream()); // Recebendo dados da maquina 1 via Socket.

        // Recebendo nome do Player 2.

        System.out.println("Informe o nome do Player 2: ");
        Scanner teclado = new Scanner(System.in);
        Output.println(teclado.nextLine());

        // Comentário


        //BufferedReader reader = new BufferedReader(streamReader);
        //String advice = reader.readLine();




    }
}
