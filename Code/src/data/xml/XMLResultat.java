package data.xml;

import model.statistic.Resultat;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.time.LocalDate;

public class XMLResultat implements Serializable {
    private String playerOne;
    private String playerTwo;
    private String winner;
    private LocalDate date;

    public XMLResultat(Resultat resultat) {
        playerOne = resultat.getPlayer1();
        playerTwo = resultat.getPlayer2();
        winner = resultat.getWinner();
        date = resultat.getDate();
    }

    private Object readResolve() throws ObjectStreamException {
        return new Resultat(playerOne, playerTwo, winner, date);
    }
}
