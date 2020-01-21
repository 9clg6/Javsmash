package data.stub;

import model.Interface.DataLoader;
import model.statistic.Resultat;
import model.statistic.Statistic;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class StubDataLoader implements DataLoader {
    private static List<Resultat> listOfTestResultat;


    public static Statistic loadResultat() {
        Statistic stats = new Statistic();
        listOfTestResultat = new ArrayList<>();

        initializeList();

        for (Resultat resultat : listOfTestResultat) {
            stats.addStatistic(resultat);
        }
        return stats;
    }

    private static void initializeList() {
        listOfTestResultat.add(new Resultat("Adrien63", "Alain63", "Adrien63", LocalDate.of(2019, Month.DECEMBER, 25)));
        listOfTestResultat.add(new Resultat("Mario37", "Gamer27", "Mario37", LocalDate.of(2019, Month.JANUARY, 12)));
        listOfTestResultat.add(new Resultat("Luigi", "Wario", "Luigi", LocalDate.of(2019, Month.MARCH, 5)));
        listOfTestResultat.add(new Resultat("Dragon25", "Gamer27", "Gamer27", LocalDate.of(2020, Month.JULY, 9)));
    }
}
