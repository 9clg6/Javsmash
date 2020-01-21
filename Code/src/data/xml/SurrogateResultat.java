package data.xml;

import model.statistic.Resultat;

import java.io.Serializable;
import java.time.LocalDate;

public class SurrogateResultat implements Serializable {
    private String playerOne;
    private String playerTwo;
    private String winner;
    private LocalDate localDate;

    public SurrogateResultat(Resultat resultat) {
        playerOne = resultat.getPlayer1();
        playerTwo = resultat.getPlayer2();
        winner = resultat.getWinner();
        localDate = resultat.getDate();
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public String getWinner() {
        return winner;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
