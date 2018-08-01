public class Players {

    private Player player1, player2;

    public Players() {
        super();
        player1 = new Player();
        player2 = new Player();
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String NamePlayers() {

        // System.out.println("Competidores: " + getPlayer1() +" X "+ getPlayer2());
        return "Competidores: " + getPlayer1().getNome() + " X " + getPlayer2().getNome();
    }
}