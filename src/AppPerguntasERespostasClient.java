import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class AppPerguntasERespostasClient {

    public static void main(String[] args) throws UnknownHostException, IOException{

        // Realizando Conexão com Servidor.

        Socket OutServidor = new Socket("127.0.0.1", 4242); // Conectando ao IP localHost:4242
        System.out.println("Conecxão Estabelecida.");
    }
}
