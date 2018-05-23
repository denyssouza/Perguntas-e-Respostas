import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException{

        // Realizando Conexão com Servidor.

        Socket Servidor = new Socket("127.0.0.1", 4242); // Conectando ao IP 127.0.0.1:4242
        System.out.println("Conexão Estabelecida.");

        PrintStream Output = new PrintStream(Servidor.getOutputStream()); // Enviando dados para maquina 1 via Socket.
        BufferedReader Input = new BufferedReader(new InputStreamReader(Servidor.getInputStream())); // Recebendo dados da maquina 1 via Socket.

        // Recebendo nome do Player 2.

        System.out.println("Informe seu nome: ");
        Scanner teclado = new Scanner(System.in);
        Output.println(teclado.nextLine());

        // Imprimindo Nome dos Competidores

        String linha = Input.readLine();
        System.out.println(linha); // Recebe o Nome dos Competidores.
        System.out.println("Aguarde as dicas do seu adversário.");

    }
}
