public class Player {

    private String nome;
    private int pontuacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void incrementaAcerto() {
        this.pontuacao += 10;
    }

    public void decrementaErro() {
        this.pontuacao -= 5;
    }
}