import java.util.Random;

public class Words {

    private String[] palavras = { "Gato", "Cachorro", "Papagaio", "Tartaruga", "Peixe" };
    private Random random; // Incializa a função Random.
    private String sorteio;

    public Words() {
        super();
        random = new Random();
        sorteio = palavras[random.nextInt(palavras.length)]; // Faz um Random da String palavras.
    }

    public String[] getPalavras() {
        return palavras;
    }

    public void setPalavras(String[] palavras) {
        this.palavras = palavras;
    }

    public String getSorteio() {
        return sorteio;
    }

    public void setSorteio(String sorteio) {
        this.sorteio = sorteio;
    }

}