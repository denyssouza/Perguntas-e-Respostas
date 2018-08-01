import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private static String linha;
    private static int limDicas;
    private static Socket servidor;
    private static Scanner teclado;

    public static void main(String[] args) throws IOException{

        servidor = new Socket("127.0.0.1", 4242);
        System.out.println("Conexão Estabelecida.");

        PrintStream Output = new PrintStream(servidor.getOutputStream()); // Enviando dados para maquina 1 via Socket.
        BufferedReader Input = new BufferedReader(new InputStreamReader(servidor.getInputStream())); // Recebendo dados da maquina 1 via Socket.

        // Recebendo nome do Player 2.
        System.out.print("Informe seu nome: ");
        teclado = new Scanner(System.in);
        Output.println(teclado.nextLine());

        // Imprimindo Nome dos Competidores
        System.out.println("---------------------------------------------");
        linha = Input.readLine();
        System.out.println(linha); // Recebe o Nome dos Competidores.
        System.out.println("---------------------------------------------");

        //recebe palavra sorteada
        linha = Input.readLine();
        String palavraSorteada = linha;


        while (true) {
            // Recebe dica do Servidor

            System.out.println("Aguarde a dica do seu adversário.");
            linha = Input.readLine();
            System.out.println("Dica Recebida: " + linha);

            // Arrisca palpite
            System.out.print("\nArrisque um palpite:");
            String palpite = (new Scanner(System.in)).nextLine();
            System.out.println("Palpite enviado: " + palpite);

            if (palpite.toUpperCase().equals(palavraSorteada.toUpperCase())) {
                Output.println("Palpite Correto!");
                System.out.println("Palpite Correto!");
                break;
            } else {
                Output.println("Palpite Errado!");
                System.out.println("Palpite Errado!");
                limDicas++;
                if (limDicas >= 3) {
                    Output.println("Numero de Tentativas Esgotado!");
                    System.out.println("Numero de Tentativas Esgotado!");
                    break;
                }
            }
        }

        System.out.println(Input.readLine());
        System.out.println(Input.readLine());
    }
}