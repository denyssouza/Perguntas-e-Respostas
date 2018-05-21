import java.util.Random;

public class Words {

    private String[] palavras = {"Gato", "Cachorro", "Papagaio", "Tartaruga", "Peixe"};

    public String[] getPalavras() {
        return palavras;
    }

    public void setPalavras(String[] palavras) {
        this.palavras = palavras;
    }

    Random random = new Random(); // Incializa a função Random.
    String sorteio = palavras[random.nextInt(palavras.length)]; // Faz um Random da String palavras.

    void Saida(){

        System.out.println(sorteio);
    }
}
