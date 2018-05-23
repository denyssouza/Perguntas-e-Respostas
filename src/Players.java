public class Players {

    private String Player1, Player2;

    public String getPlayer1() {
        return Player1;
    }

    public void setPlayer1(String player1) {
        Player1 = player1;
    }

    public String getPlayer2() {
        return Player2;
    }

    public void setPlayer2(String player2) {
        Player2 = player2;
    }

    public String NamePlayers(){

       // System.out.println("Competidores: " + getPlayer1() +" X "+ getPlayer2());
        return "Competidores: " + getPlayer1() +" X "+ getPlayer2();
    }
}