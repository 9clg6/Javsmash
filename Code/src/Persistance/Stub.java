package Persistance;

import model.statistic.Statistic;
import model.statistic.Resultat;

public class Stub {

    public static Statistic chargerStatistic(){
        Statistic stats = new Statistic();
        stats.addStatistic(new Resultat("Adrien63","Alain63","Adrien63"));
        stats.addStatistic(new Resultat("Mario37","Gamer27","Mario37"));
        stats.addStatistic(new Resultat("Luigi","Wario","Luigi"));
        stats.addStatistic(new Resultat("Dragon25","Gamer27","Dragon25"));

        return stats;
    }


}
