import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    private static ServerSocket servidor;
    private static Scanner nomeJogador;

    public static void main (String[] args) throws IOException {

        servidor = new ServerSocket(4242);
        System.out.println("Servidor Iniciado...");
        Socket Cliente = servidor.accept(); // Permite conexão.
        System.out.println("Conexão Estabelecida com: " + Cliente.getInetAddress().getHostAddress()); // Apresenta IP e Host.

        BufferedReader Input = new BufferedReader(new InputStreamReader(Cliente.getInputStream())); // Recebendo dados da maquina 2 via Socket.
        PrintStream Output = new PrintStream(Cliente.getOutputStream()); // Enviando dados para maquina 1 via Socket.

        nomeJogador = new Scanner(System.in);
        Players players = new Players();

        System.out.print("Informe seu nome: ");
        players.getPlayer1().setNome(nomeJogador.nextLine()); // Armazenando nome de Player 1.
        players.getPlayer2().setNome(Input.readLine());   // Armazenando nome de Player 2.

        Output.println(players.NamePlayers()); // Imprime para Cliente.
        System.out.println(players.NamePlayers()); // Imprime para Servidor.

        sorteiaPalavra(Output);

        String palpite = null;

        //Recebe no maximo 3 dicas
        for (int i = 0; i < 3; i++) {
            recebeDica(Output, players);
            palpite = Input.readLine();
            //verifica se o palpite foi correto
            if (!palpite.trim().equals("Palpite Errado!")) {
                break;
            }
        }
        System.out.println(palpite);

        processaPontuacao(players.getPlayer2(), palpite);

        mostraPontuacao(Output, players);
    }

    //processa a pontuacao do jogador, se ele acertou ou errou todas as 3 tentativas
    private static void processaPontuacao(Player player, String palpite) {
        if (palpite.equals("Palpite Correto!")){
            player.incrementaAcerto();
        }else{
            player.decrementaErro();
        }
    }

    // Sorteio da Palavra para Player 1 e envia ao PLayer 2.
    private static void sorteiaPalavra(PrintStream Output) {
        System.out.println("---------------------------------------------");
        Words palavra = new Words();
        System.out.println("Competidor, sua palavra é: " + palavra.getSorteio()); //Sorteio da palavra para Player 1.
        System.out.println("---------------------------------------------");
        Output.println(palavra.getSorteio());
    }

    //imprime no servidor e envia para o cliente a pontuacao dos players
    private static void mostraPontuacao(PrintStream Output, Players players) {
        Output.println("Pontuacao Player 1: " + players.getPlayer1().getPontuacao());
        Output.println("Pontuacao Player 2: " + players.getPlayer2().getPontuacao());

        System.out.println("Pontuacao Player 1: " + players.getPlayer1().getPontuacao());
        System.out.println("Pontuacao Player 2: " + players.getPlayer2().getPontuacao());
    }

    //Recebe Dica da entrada e passa ao cliente
    private static void recebeDica(PrintStream Output, Players players) {
        System.out.print("Informe uma dica para " + players.getPlayer2().getNome() + ": ");
        String dica = (new Scanner(System.in)).nextLine();
        System.out.println("Dica enviada: " + dica + "\n");
        Output.println(dica);
    }
}