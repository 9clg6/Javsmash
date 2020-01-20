package data.stub;

import model.Interface.DataLoader;
import model.statistic.Resultat;
import model.statistic.Statistic;

import java.time.LocalDate;
import java.time.Month;

public class StubDataLoader implements DataLoader {

    public static Statistic loadResultat() {
        Statistic stats = new Statistic();
        stats.addStatistic(new Resultat("Adrien63", "Alain63", "Adrien63", LocalDate.of(2019, Month.DECEMBER, 25)));
        stats.addStatistic(new Resultat("Mario37", "Gamer27", "Mario37", LocalDate.of(2019, Month.JANUARY, 12)));
        stats.addStatistic(new Resultat("Luigi", "Wario", "Luigi", LocalDate.of(2019, Month.MARCH, 5)));
        stats.addStatistic(new Resultat("Dragon25", "Gamer27", "Gamer27", LocalDate.of(2020, Month.JULY, 9)));

        return stats;
    }
}
