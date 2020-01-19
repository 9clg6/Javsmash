package model.statistic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Resultat {

    private final StringProperty player1 = new SimpleStringProperty();
        public String getPlayer1() {return player1.get();}
        public StringProperty player1Property() {return player1;}
        public void setPlayer1(String player1) {this.player1.set(player1);}



    private final StringProperty player2 = new SimpleStringProperty();
        public String getPlayer2() {return player2.get();}
        public StringProperty player2Property() {return player2;}
        public void setPlayer2(String player2) {this.player2.set(player2);}

    private final StringProperty winner = new SimpleStringProperty();
        public String getWinner() {return winner.get();}
        public StringProperty winnerProperty() {return winner;}
        public void setWinner(String winner) {this.winner.set(winner);}




    public Resultat(String player1, String player2, String winner) {
        this.player1.set(player1);
        this.player2.set(player2);
        this.winner.set(winner);

    }
}
