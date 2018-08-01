public class Pessoa {

    private String nome;
    private Long CPF;
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @return the cPF
     */
    public Long getCPF() {
        return CPF;
    }
    /**
     * @param cPF the cPF to set
     */
    public void setCPF(Long cPF) {
        CPF = cPF;
    }

    public String retornaDados(){
        return "Eu nao gosto de jogos, seguem meus dados!\n[Dados(Pessoa)] - Nome: " + this.getNome() + ", CPF: " + this.getCPF();
    }
}