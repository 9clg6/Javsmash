package model.statistic;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Resultat {

    private final StringProperty player1 = new SimpleStringProperty();
    private final StringProperty player2 = new SimpleStringProperty();
    private final StringProperty winner = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();


    public Resultat(String player1, String player2, String winner, LocalDate date) {
        this.player1.set(player1);
        this.player2.set(player2);
        this.winner.set(winner);
        this.date.set(date);

    }

    public String getPlayer1() {
        return player1.get();
    }

    public void setPlayer1(String player1) {
        this.player1.set(player1);
    }

    public StringProperty player1Property() {
        return player1;
    }

    public String getPlayer2() {
        return player2.get();
    }

    public void setPlayer2(String player2) {
        this.player2.set(player2);
    }

    public StringProperty player2Property() {
        return player2;
    }

    public String getWinner() {
        return winner.get();
    }

    public void setWinner(String winner) {
        this.winner.set(winner);
    }

    public StringProperty winnerProperty() {
        return winner;
    }

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate birthday) {
        this.date.set(birthday);
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }
}
